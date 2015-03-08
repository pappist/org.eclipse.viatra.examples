package org.eclipse.viatra.dse.examples.bpmn.patterns;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;
import org.eclipse.viatra.dse.examples.bpmn.patterns.EveryTaskHasVariantMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.EveryTaskHasVariantQuerySpecification;

/**
 * Generated pattern matcher API of the org.eclipse.viatra.dse.examples.bpmn.patterns.everyTaskHasVariant pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link EveryTaskHasVariantMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern everyTaskHasVariant() {
 * 	neg find unassignedTask(_);
 * }
 * </pre></code>
 * 
 * @see EveryTaskHasVariantMatch
 * @see EveryTaskHasVariantProcessor
 * @see EveryTaskHasVariantQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class EveryTaskHasVariantMatcher extends BaseMatcher<EveryTaskHasVariantMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static EveryTaskHasVariantMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    EveryTaskHasVariantMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new EveryTaskHasVariantMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(EveryTaskHasVariantMatcher.class);
  
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
  public EveryTaskHasVariantMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public EveryTaskHasVariantMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Indicates whether the (parameterless) pattern matches or not.
   * @return true if the pattern has a valid match.
   * 
   */
  public boolean hasMatch() {
    return rawHasMatch(new Object[]{});
  }
  
  @Override
  protected EveryTaskHasVariantMatch tupleToMatch(final Tuple t) {
    try {
    	return EveryTaskHasVariantMatch.newMatch();
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected EveryTaskHasVariantMatch arrayToMatch(final Object[] match) {
    try {
    	return EveryTaskHasVariantMatch.newMatch();
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected EveryTaskHasVariantMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return EveryTaskHasVariantMatch.newMutableMatch();
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
  public static IQuerySpecification<EveryTaskHasVariantMatcher> querySpecification() throws IncQueryException {
    return EveryTaskHasVariantQuerySpecification.instance();
  }
}
