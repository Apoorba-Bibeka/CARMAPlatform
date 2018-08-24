package gov.dot.fhwa.saxton.carma.signal_plugin.ead.trajectorytree;

import gov.dot.fhwa.saxton.carma.signal_plugin.asd.IntersectionData;
import gov.dot.fhwa.saxton.carma.signal_plugin.ead.INodeCollisionChecker;

import java.util.List;

/**
 * Interface defining the functions needed calculating node neighbors for use with ITreeSolver
 */
public interface INeighborCalculator {

  /**
   * Provides all of the initial data necessary to identify neighbors in an EAD environment
   * @param intersections - list of known intersections, sorted in order from nearest to farthest
   * @param numIntersections - the number of intersections to consider in this solution
   * @param timeIncrement - increment between adjacent time points in the grid, sec
   * @param speedIncrement - increment between adjacent speed points in the grid, m/s
   */
  void initialize(List<IntersectionData> intersections, int numIntersections, double timeIncrement,
                  double speedIncrement, INodeCollisionChecker collisionChecker);

  /**
   * Gets a list of neighbors to the provided node
   * @param node The node
   * @return List of node's neighbors
   */
  List<Node> neighbors(Node node);


  /**
   * Stores the vehicle's desired speed if traffic signals posed no constraint
   * @param os - operating speed, m/s
   */
  void setOperatingSpeed(double os);
}
