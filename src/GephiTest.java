import org.gephi.filters.plugin.attribute.AttributeEqualBuilder.EqualBooleanFilter.Edge;
import org.gephi.graph.api.DirectedGraph;
import org.gephi.graph.api.GraphController;
import org.gephi.graph.api.GraphModel;
import org.gephi.graph.api.Node;
import org.gephi.graph.api.UndirectedGraph;
import org.gephi.io.generator.plugin.RandomGraph;
import org.gephi.io.importer.api.ImportController;
import org.gephi.io.processor.plugin.DefaultProcessor;
import org.gephi.layout.plugin.AutoLayout;
import org.gephi.layout.plugin.force.StepDisplacement;
import org.gephi.layout.plugin.force.yifanHu.YifanHuLayout;
import org.gephi.layout.plugin.forceAtlas.ForceAtlasLayout;
import org.gephi.project.api.ProjectController;
import org.gephi.project.api.Workspace;
import org.json.simple.parser.ContainerFactory;
import org.openide.util.Lookup;

import java.awt.Container;
import java.util.concurrent.TimeUnit;


public class GephiTest {


	public GephiTest() {
		//Init a project - and therefore a workspace
		ProjectController pc = Lookup.getDefault().lookup(ProjectController.class);
		pc.newProject();
		Workspace workspace = pc.getCurrentWorkspace();

		//Generate a new random graph into a container
		Container container = (Container) Lookup.getDefault().lookup(ContainerFactory.class);
		RandomGraph randomGraph = new RandomGraph();
		randomGraph.setNumberOfNodes(500);
		randomGraph.setWiringProbability(0.005);
		//randomGraph.generate(((org.gephi.io.importer.api.Container) container).getLoader());

		//Append container to graph structure
		ImportController importController = Lookup.getDefault().lookup(ImportController.class);
		//importController.process((org.gephi.io.importer.api.Container) container, new DefaultProcessor(), workspace);

		//See if graph is well imported
		GraphModel graphModel = Lookup.getDefault().lookup(GraphController.class).getGraphModel();
		DirectedGraph graph = graphModel.getDirectedGraph();
		System.out.println("Nodes: " + graph.getNodeCount());
		System.out.println("Edges: " + graph.getEdgeCount());

		//Layout for 1 minute
		AutoLayout autoLayout = new AutoLayout(1, TimeUnit.MINUTES);
		autoLayout.setGraphModel(graphModel);
		YifanHuLayout firstLayout = new YifanHuLayout(null, new StepDisplacement(1f));
		ForceAtlasLayout secondLayout = new ForceAtlasLayout(null);
		AutoLayout.DynamicProperty adjustBySizeProperty = AutoLayout.createDynamicProperty("forceAtlas.adjustSizes.name", Boolean.TRUE, 0.1f);//True after 10% of layout time
		AutoLayout.DynamicProperty repulsionProperty = AutoLayout.createDynamicProperty("forceAtlas.repulsionStrength.name", new Double(500.), 0f);//500 for the complete period
		autoLayout.addLayout(firstLayout, 0.5f);
		autoLayout.addLayout(secondLayout, 0.5f, new AutoLayout.DynamicProperty[]{adjustBySizeProperty, repulsionProperty});
		autoLayout.execute();
	}
	
	
	public static void main(String[] args) {
		new GephiTest();
	}

	
}
