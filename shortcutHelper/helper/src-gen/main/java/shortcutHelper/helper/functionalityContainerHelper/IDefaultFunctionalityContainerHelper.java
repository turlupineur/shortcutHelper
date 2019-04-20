package shortcutHelper.helper.functionalityContainerHelper;
import shortcutHelper.helper.Helper;

public interface IDefaultFunctionalityContainerHelper extends Helper{
	public static final String BEAN_ID = "FunctionalityContainerHelper";

    public Object createDefaultContainerForFunctionality(Class clazz);


    public Object createDefaultContainerForFunctionality(Object _functionality);


    public Object getContainerExtractorFunctionality(Object _functionality);


    public Object getContainerExtractorFunctionality(Class clazz);


    public void fillContainerWithParams(Class clazzFunctionality,Object container,String [] params);


    public Object createAndFillContainer(Class clazz,String [] params);


    public Object createAndFillContainer(Object _functionality,String [] params);

}