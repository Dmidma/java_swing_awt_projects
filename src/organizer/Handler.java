package organizer;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import general.definition.JListFileRenderer;
import general.definition.Window;

public class Handler implements ActionListener, TreeSelectionListener, MouseListener{
	
	
	// String of the current Directory
	private String currentDirectory = "C:";
	// Two stacks for visited directories and toVisit directories 
	private Stack<String> previousDirectories = new Stack<String>();
	private Stack<String> nextDirectories = new Stack<String>();
	
	

	private DefaultMutableTreeNode top;
	private DefaultTreeModel curr;
	private JTree tree;
	
	private JList<File> textArea;
	private DefaultListModel<File> listModel;
	
	// the main GUI
	private MainPanel mainPanel = null;
	
	public Handler(Window window) {
		
		mainPanel = new MainPanel(window);
		
		configButtonsAndPath();
		
		configList();
		
		configTree();
		
		// add menu to the window
		new MenuMonitor(window, mainPanel.getPathField());
		
		File firstFile = new File(this.currentDirectory);
		listHandling(firstFile);
		treeHandling(firstFile, this.top);
	}
	
	
	/**
	 * This private method will add the non-repeated elements from the stack
	 * to the hash set.
	 * @param aStack
	 * @param aHashSet
	 */
	private void addToHash(Stack<String> aStack, HashSet<String> aHashSet) {
		
		// iterate over the stack and add only the not repeated strings
		for (Iterator<String> i = aStack.iterator(); i.hasNext();) {
			String current = i.next();
			if (!aHashSet.contains(current))
				aHashSet.add(current);
		}
	}

	/**
	 * This method will return the visited directories in a hash set.
	 * @return the hash set that will contain the visited directories
	 */
	public HashSet<String> openedTree() {
		// this hash set will contain the visited directories without repetition
		HashSet<String> availableTree = new HashSet<String>();
		availableTree.add(currentDirectory);
		
		addToHash(previousDirectories, availableTree);
		addToHash(nextDirectories, availableTree);
		
		return availableTree;
	}
	
	/**
	 * This private method makes sure that the path in the JTextField is a valid one,
	 * which means it exists and it is a path of directory
	 * @return true if the path is of a valid directory, else false.
	 */
	private boolean pathHandling() {
		
		String path = mainPanel.getPathField().getText();
		
		File currDir = new File(path);
		
		if (currDir != null && currDir.isDirectory()) {
			listHandling(currDir);
			//treeHandling(currDir, this.top);
			return true;
		}
		
		mainPanel.getPathField().setText(currentDirectory);
		
		return false;
	}

	
	private void listHandling(File file) {
		
		// stop if we have invalid file or it is not a directory
		if (file == null || !file.isDirectory())
			return;
		
		
		// remove old elements
		listModel.removeAllElements();
		
		// retrieve the files of the current directory
		File[] listf = file.listFiles();
		
		// the list will be empty
		if (listf == null) {
			listModel.addElement(null);
			return;
		}
		
		// add all available files of the current directory
		for (File i : listf) {
			listModel.addElement(i);
		}
	}
	
	private void treeHandling(File file, DefaultMutableTreeNode top) {
		if (!file.exists())
			return;

		File[] listf = file.listFiles();
		if (listf == null)
			return;
		
		top.removeAllChildren();
		
		for (File i : listf) {
			if (i.isDirectory()) {
				DefaultMutableTreeNode one = new DefaultMutableTreeNode(i.getName());
				curr.insertNodeInto(one, top, top.getChildCount());
				curr.insertNodeInto(new DefaultMutableTreeNode(""), one, one.getChildCount());
			}
		}
	}

	
	private void configList() {
		// setting the JList
		listModel = new DefaultListModel<File>();
		textArea = new JList<File>(listModel);
		textArea.setCellRenderer(new JListFileRenderer());
		textArea.addMouseListener(this);
		mainPanel.getDirecPane().getViewport().add(textArea, BorderLayout.CENTER);
	}
	
	
	private void configButtonsAndPath() {
		
		// add ActionListener to the two buttons
		mainPanel.getPrev().addActionListener(this);
		mainPanel.getNext().addActionListener(this);
		// add ActionListener to the PathField
		mainPanel.getPathField().addActionListener(this);
	}
	
	
	private void configTree() {
		
		// set the top Node
		top = new DefaultMutableTreeNode(currentDirectory);
		curr = new DefaultTreeModel(top);
		
		tree = new JTree(top);
		tree.setEditable(false);
		tree.getSelectionModel()
			.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setShowsRootHandles(true);


		// add the Listener to the tree
		tree.addTreeSelectionListener(this);

		// add the tree to the mainPanel
		mainPanel.getTreePane().getViewport().add(tree);
	}
	
	
	/**
	 * Method that will handles the tree.
	 */
	public void valueChanged(TreeSelectionEvent e) {
		
		// get which directory was selected
		TreePath path = e.getPath();
		
		// create a path from the treePath
		String newDirectory = "";
		for (int i = 0; i < path.getPathCount(); i++) {
			newDirectory = newDirectory.concat(path.getPathComponent(i).toString()).concat("\\");
		}
		
		previousDirectories.push(currentDirectory);
		
		mainPanel.getPathField().setText(newDirectory);
		
		currentDirectory = newDirectory;
		

		File fil = new File(mainPanel.getPathField().getText());
		listHandling(fil);
		File[] listfe = fil.listFiles();
		if (listfe == null) {
			return;
		}
		
		// checking for sub-directories
		boolean noSubDirectories = false;
		checkSub:
		for (File i: listfe) {
			if (i.isDirectory())
			{
				noSubDirectories = true;
				break checkSub;
			}
		}
		// stop, if no subDirectories were found
		if (noSubDirectories == false) {
			return;
		}
		
		// change the tree
		treeHandling(fil, (DefaultMutableTreeNode)(path.getLastPathComponent()));
	}

	/**
	 * Method that will handles the two buttons.
	 */
	public void actionPerformed(ActionEvent e) {
		
		
		if ("<-".equals(e.getActionCommand())) {
			changeStackDir(previousDirectories, nextDirectories);
		}
		else if ("->".equals(e.getActionCommand())) {
			changeStackDir(nextDirectories, previousDirectories);
		}
		else if (e.getSource().getClass().toString().endsWith("JTextField")) {
			pathHandling();
		}
	}

	
	/**
	 * 
	 * @param first
	 * @param second
	 */
	private void changeStackDir(Stack<String> first, Stack<String> second) {
		
		// Stop if stack is empty
		if (first.empty())
			return;
		
		// Poll string from the first queue
		String chanDir = first.pop();
		
		// add the current directory to the second queue
		second.push(currentDirectory);
		
		// change the current directory
		currentDirectory = chanDir;
		
		// update the path field
		mainPanel.getPathField().setText(currentDirectory);
		pathHandling();
		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		// only accept the double click
		if (arg0.getClickCount() == 2) {
			// casting without specifying the generic type
			@SuppressWarnings("rawtypes")
			String selectedFile = ((JList)arg0.getSource()).getSelectedValue().toString();
			
			File newFile = new File(selectedFile);
			if (newFile == null || !newFile.isDirectory())
				return;
			previousDirectories.push(currentDirectory);
			currentDirectory = selectedFile;
			
			mainPanel.getPathField().setText(currentDirectory);
			
			listHandling(newFile);
			
			// TODO: iterate over the directories
			//treeHandling(newFile, top);
			
		}
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}





}
