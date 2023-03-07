This problem based on ***Binary search on answer*** this is famous technique to solve these kind of problems.
​
**Brute force approach** -
* just iterate through time array and count trips of each bus `
** for(int i = 0; i<time.length; i++)
{     sum+= t/time[i]; }`**
*  **if sum >= totalTrips** then return time.
​
​
**Optimal Solution - Binary search **
​
compute lower index and higher index and apply treditional binary search algorithm
​