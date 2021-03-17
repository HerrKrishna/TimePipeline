package TimePipeline;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.apache.uima.fit.factory.CollectionReaderFactory.createReaderDescription;
import static org.apache.uima.fit.pipeline.SimplePipeline.runPipeline;
import org.apache.commons.cli.*;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.fit.factory.AggregateBuilder;
import org.apache.uima.fit.factory.TypeSystemDescriptionFactory;
import org.apache.uima.resource.metadata.TypeSystemDescription;

import de.tudarmstadt.ukp.dkpro.core.io.xmi.XmiWriter;
import de.tudarmstadt.ukp.dkpro.core.io.bincas.BinaryCasWriter;
import de.tudarmstadt.ukp.dkpro.core.io.text.TextReader;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpSegmenter;
import de.tudarmstadt.ukp.dkpro.core.sfst.SfstAnnotator;
import de.tudarmstadt.ukp.dkpro.core.ixa.IxaLemmatizer;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpPosTagger;
import de.tudarmstadt.ukp.dkpro.core.corenlp.CoreNlpParser;
import de.tudarmstadt.ukp.dkpro.core.corenlp.CoreNlpDependencyParser;
import de.tudarmstadt.ukp.dkpro.core.corenlp.CoreNlpCoreferenceResolver;

public class TimePipeline {
	
	public static void main(String[] args) throws Exception {  
		    
	  	
	  	Options options = new Options();
	
	    Option input = new Option("i", "input", true, "input file path");
	    input.setRequired(true);
	    options.addOption(input);
	
	    Option output = new Option("o", "output", true, "output file");
	    output.setRequired(true);
	    options.addOption(output);
	    
	    Option bin = new Option("bin", "binary", false, "output binaryCas");
	    options.addOption(bin);
	    
	    Option dep = new Option("dep", "dependency", false, "add CoreNLPDependency Parser");
	    options.addOption(dep);
	    
	    Option heidelTime = new Option("hTime", "heidelTime", false, "add heidelTime");
	    options.addOption(heidelTime);
	
	    CommandLineParser parser = new DefaultParser();
	    HelpFormatter formatter = new HelpFormatter();
	    CommandLine cmd = null;
	
	    try {
	        cmd = parser.parse(options, args);
	    } catch (ParseException e) {
	        System.out.println(e.getMessage());
	        formatter.printHelp("utility-name", options);
	
	        System.exit(1);
	    }
	    
	    String input_Path = cmd.getOptionValue("input");
	    String output_Path = cmd.getOptionValue("output");
	    
        AggregateBuilder builder = new AggregateBuilder();
	    
	    builder.add(createEngineDescription(OpenNlpSegmenter.class,
	        	OpenNlpSegmenter.PARAM_SEGMENTATION_MODEL_LOCATION, "Models/de-sent.bin"));
	    builder.add(createEngineDescription(OpenNlpPosTagger.class));
	    builder.add(createEngineDescription(IxaLemmatizer.class));
	    
	    if (cmd.hasOption("dependency")) {
	    	builder.add(createEngineDescription(CoreNlpDependencyParser.class,
	        	CoreNlpDependencyParser.PARAM_MODEL_ARTIFACT_URI, "mvn:de.tudarmstadt.ukp.dkpro.core:de.tudarmstadt.ukp.dkpro.core.corenlp-model-depparser-de-ud:20161213.1",
	        	CoreNlpDependencyParser.PARAM_MODEL_LOCATION, "Models/depparser-de-ud.properties"));
	    }
	    
	    if (cmd.hasOption("heidelTime")) {
	    	System.out.println("\n\n -----------------------------------------------------------\n"
	    			+ "You added heidelTime. Make sure that the environment variable TreeTaggerHome is set \n"
	    			+ "---------------------------------------------------------------------------\n");
	    	builder.add(createEngineDescription("desc.annotator/TreeTaggerWrapper"));
	    	builder.add(createEngineDescription("desc.annotator/HeidelTime"));
	    }

	    if (cmd.hasOption("bin")) {
	    	builder.add(createEngineDescription(BinaryCasWriter.class,
			        							BinaryCasWriter.PARAM_TARGET_LOCATION, output_Path,
												BinaryCasWriter.PARAM_OVERWRITE, true,
												BinaryCasWriter.PARAM_STRIP_EXTENSION, true,
												BinaryCasWriter.PARAM_FILENAME_EXTENSION, ".bcas"));
	    } else {
	    	builder.add(createEngineDescription(XmiWriter.class,
    	        							    XmiWriter.PARAM_PRETTY_PRINT, true,
    	        							    XmiWriter.PARAM_OVERWRITE, true,
    	        							    XmiWriter.PARAM_TARGET_LOCATION, output_Path,
    	        							    XmiWriter.PARAM_STRIP_EXTENSION, true));
	    }
	  
	    //treetagger home needs to be set
	    //needs 1G of ram
	  
	   AnalysisEngineDescription aggregate = builder.createAggregateDescription();
	   
	   runPipeline(createReaderDescription(TextReader.class, 
								           TextReader.PARAM_SOURCE_LOCATION, input_Path,
								           TextReader.PARAM_LANGUAGE, "de"),
			   	   aggregate);
	    

	 }
}