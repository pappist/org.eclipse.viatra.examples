package headless.util;

import com.google.common.collect.Sets;
import headless.EObjectMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.context.EMFPatternMatcherContext;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.PQuery.PQueryStatus;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;

/**
 * A pattern-specific query specification that can instantiate EObjectMatcher in a type-safe way.
 * 
 * @see EObjectMatcher
 * @see EObjectMatch
 * 
 */
@SuppressWarnings("all")
public final class EObjectQuerySpecification extends BaseGeneratedQuerySpecification<EObjectMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EObjectQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected EObjectMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EObjectMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "headless.eObject";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("o");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("o", "org.eclipse.emf.ecore.EObject"));
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    EMFPatternMatcherContext context = new EMFPatternMatcherContext();
    Set<PBody> bodies = Sets.newHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_o = body.getOrCreateVariableByName("o");
      body.setExportedParameters(Arrays.asList(
        new ExportedParameter(body, var_o, "o")
      ));
      
      new TypeUnary(body, var_o, getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EObject"), "http://www.eclipse.org/emf/2002/Ecore/EObject");
      bodies.add(body);
    }setStatus(PQueryStatus.OK);
    return bodies;
  }
  
  private EObjectQuerySpecification() throws IncQueryException {
    super();
    setStatus(PQueryStatus.UNINITIALIZED);
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<EObjectQuerySpecification> {
    @Override
    public EObjectQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static EObjectQuerySpecification INSTANCE = make();
    
    public static EObjectQuerySpecification make() {
      try {
      	return new EObjectQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
