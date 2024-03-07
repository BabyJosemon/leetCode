So this question is basically the same as finding top k smallest elements in a list where we
used a maxheap to solve. But some things to consider:
1. The maxheap needs to store points such that the point with largest distance from origin
is stored at root.
2. To do that we need to have a priority queue that stores int[] and it needs to define a
comparator that says given 2 points p1, p2 distance of p1 from origin - distance of p2 from
origin compares the distances of two points from the origin. If p1 is farther from the origin than p2, the result will be positive, indicating that p1 should have higher priority. If p2 is farther from the origin than p1, the result will be negative, indicating that p2 should have higher priority. If both points are equidistant from the origin, the result will be 0.
3. We need to define a distanceFromOrigin method that returns distance from [0,0] for a
point but we omit the math.sqrt as we dont need to return double type.
4. Then its just regular add k elements to maxheap using comparator and then for elements
after k we only add if current points distance to origin is smaller than root.
5. Since method requires a int[][] return type we create a resultArray of size equal to
maxheap number of points and each of size 2. Then we iterate through all int[] points in
maxheap and add to resultArray.