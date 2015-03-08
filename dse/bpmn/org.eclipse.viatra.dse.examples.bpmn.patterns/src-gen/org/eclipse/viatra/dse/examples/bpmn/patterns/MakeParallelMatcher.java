package org.eclipse.viatra.dse.examples.bpmn.patterns;

import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeParallelMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.MakeParallelQuerySpecification;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;

/**
 * Generated pattern matcher API of the org.eclipse.viatra.dse.examples.bpmn.patterns.makeParallel pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link MakeParallelMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern makeParallel(T1 : Task, T2 : Task, Root : SimplifiedBPMN) {
 * 	SimplifiedBPMN(Root);
 * 	Task.outFlows(T1, out);
 * 	SequenceFlow.isDataFlow(out, false);
 * 	SequenceFlow.target(out, T2);
 * 	T1 != T2;
 * 	1 == count find inFlow(T2, _);
 * 	1 == count find outFlow(T1, _);
 * }
 * </pre></code>
 * 
 * @see MakeParallelMatch
 * @see MakeParallelProcessor
 * @see MakeParallelQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class MakeParallelMatcher extends BaseMatcher<MakeParallelMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static MakeParallelMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    MakeParallelMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new MakeParallelMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_T1 = 0;
  
  private final static int POSITION_T2 = 1;
  
  private final static int POSITION_ROOT = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(MakeParallelMatcher.class);
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet).
   * If a pattern matcher is already constructed with the same root, only a light-weight reference is returned.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead, e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}
   * 
   */
  @Deprecated
  public MakeParallelMatcher(final Notifier emfRoot) throws IncQueryException {
    this(IncQueryEngine.on(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead
   * 
   */
  @Deprecated
  public MakeParallelMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @param pRoot the fixed value of pattern parameter Root, or null if not bound.
   * @return matches represented as a MakeParallelMatch object.
   * 
   */
  public Collection<MakeParallelMatch> getAllMatches(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot) {
    return rawGetAllMatches(new Object[]{pT1, pT2, pRoot});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @param pRoot the fixed value of pattern parameter Root, or null if not bound.
   * @return a match represented as a MakeParallelMatch object, or null if no match is found.
   * 
   */
  public MakeParallelMatch getOneArbitraryMatch(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot) {
    return rawGetOneArbitraryMatch(new Object[]{pT1, pT2, pRoot});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @param pRoot the fixed value of pattern parameter Root, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot) {
    return rawHasMatch(new Object[]{pT1, pT2, pRoot});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @param pRoot the fixed value of pattern parameter Root, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot) {
    return rawCountMatches(new Object[]{pT1, pT2, pRoot});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @param pRoot the fixed value of pattern parameter Root, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot, final IMatchProcessor<? super MakeParallelMatch> processor) {
    rawForEachMatch(new Object[]{pT1, pT2, pRoot}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @param pRoot the fixed value of pattern parameter Root, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot, final IMatchProcessor<? super MakeParallelMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pT1, pT2, pRoot}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pT1 the fixed value of pattern parameter T1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter T2, or null if not bound.
   * @param pRoot the fixed value of pattern parameter Root, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public MakeParallelMatch newMatch(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot) {
    return MakeParallelMatch.newMatch(pT1, pT2, pRoot);
  }
  
  /**
   * Retrieve the set of values that occur in matches for T1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Task> rawAccumulateAllValuesOfT1(final Object[] parameters) {
    Set<Task> results = new HashSet<Task>();
    rawAccumulateAllValues(POSITION_T1, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for T1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT1() {
    return rawAccumulateAllValuesOfT1(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for T1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT1(final MakeParallelMatch partialMatch) {
    return rawAccumulateAllValuesOfT1(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for T1.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT1(final Task pT2, final SimplifiedBPMN pRoot) {
    return rawAccumulateAllValuesOfT1(new Object[]{
    null, 
    pT2, 
    pRoot
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for T2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Task> rawAccumulateAllValuesOfT2(final Object[] parameters) {
    Set<Task> results = new HashSet<Task>();
    rawAccumulateAllValues(POSITION_T2, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for T2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT2() {
    return rawAccumulateAllValuesOfT2(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for T2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT2(final MakeParallelMatch partialMatch) {
    return rawAccumulateAllValuesOfT2(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for T2.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Task> getAllValuesOfT2(final Task pT1, final SimplifiedBPMN pRoot) {
    return rawAccumulateAllValuesOfT2(new Object[]{
    pT1, 
    null, 
    pRoot
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for Root.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected /* Set<SimplifiedBPMN> */Object rawAccumulateAllValuesOfRoot(final Object[] parameters) {
    Set<SimplifiedBPMN> results = new HashSet<SimplifiedBPMN>();
    rawAccumulateAllValues(POSITION_ROOT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for Root.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public /* Set<SimplifiedBPMN> */Object getAllValuesOfRoot() {
    return rawAccumulateAllValuesOfRoot(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Root.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public /* Set<SimplifiedBPMN> */Object getAllValuesOfRoot(final MakeParallelMatch partialMatch) {
    return rawAccumulateAllValuesOfRoot(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for Root.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public /* Set<SimplifiedBPMN> */Object getAllValuesOfRoot(final Task pT1, final Task pT2) {
    return rawAccumulateAllValuesOfRoot(new Object[]{
    pT1, 
    pT2, 
    null
    });
  }
  
  @Override
  protected MakeParallelMatch tupleToMatch(final Tuple t) {
    try {
    	return MakeParallelMatch.newMatch((org.eclipse.viatra.dse.examples.simplifiedbpmn.Task) t.get(POSITION_T1), (org.eclipse.viatra.dse.examples.simplifiedbpmn.Task) t.get(POSITION_T2), (SimplifiedBPMN) t.get(POSITION_ROOT));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MakeParallelMatch arrayToMatch(final Object[] match) {
    try {
    	return MakeParallelMatch.newMatch((org.eclipse.viatra.dse.examples.simplifiedbpmn.Task) match[POSITION_T1], (org.eclipse.viatra.dse.examples.simplifiedbpmn.Task) match[POSITION_T2], (SimplifiedBPMN) match[POSITION_ROOT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected MakeParallelMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return MakeParallelMatch.newMutableMatch((org.eclipse.viatra.dse.examples.simplifiedbpmn.Task) match[POSITION_T1], (org.eclipse.viatra.dse.examples.simplifiedbpmn.Task) match[POSITION_T2], (SimplifiedBPMN) match[POSITION_ROOT]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<MakeParallelMatcher> querySpecification() throws IncQueryException {
    return MakeParallelQuerySpecification.instance();
  }
}
