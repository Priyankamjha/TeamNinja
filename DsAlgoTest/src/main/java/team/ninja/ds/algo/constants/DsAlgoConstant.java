package team.ninja.ds.algo.constants;

import team.ninja.ds.algo.utilities.ConfigReader;

public class DsAlgoConstant {
	public static final String CONFIG_FILE_PATH="src/test/resources/test-config/Config.properties";

	static ConfigReader configReader = ConfigReader.getInstance();
	public static final String XL_QDATA_FILE_PATH=configReader.getProperty("quequeTestDataFilePath");
	
	public static final String homePageUrl =configReader.getProperty("homePageUrl");//added to test
	public static final String queueUrl = configReader.getProperty("queueUrl");
	public static final String impOfQPython = configReader.getProperty("impOfQPython");
	public static final String impColDeq = configReader.getProperty("impColDeq");
	public static final String impUsingArray = configReader.getProperty("impUsingArray");
	public static final String queueOp = configReader.getProperty("queueOp");
	public static final String practiceQs = configReader.getProperty("practiceQs");
	public static final String tryEditor = configReader.getProperty("tryEditor");
	
	public static final String graphUrl = configReader.getProperty("graphUrl");
	public static final String graphLink =configReader.getProperty("graphLink");
	public static final String graphRepLink = configReader.getProperty("graphRepLink");
	public static final String graphPracticeQs = configReader.getProperty("graphPracticeQs");
	
	
}
