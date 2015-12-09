package pahinave.algorithms.problems.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pahinave.algorithms.problems.Interval;
import pahinave.algorithms.problems.Intervals;

public class IntervalsTest {
	@Test
	public void testOverlappingIntervals() throws Exception {
		
		Interval i1 = new Interval(5, 10);
		Interval i2 = new Interval(1, 4);
		Interval i3 = new Interval(1, 5);
		Interval i4 = new Interval(1, 7);
		Interval i5 = new Interval(1, 10);
		Interval i6 = new Interval(1, 14);
		Interval i7 = new Interval(5,7);
		Interval i8 = new Interval(5,10);
		Interval i9 = new Interval(5,13);
		Interval i10 = new Interval(7,7);
		Interval i11 = new Interval(8,10);
		Interval i12 = new Interval(8,12);
		Interval i13 = new Interval(11,15);
		
		Intervals i = new Intervals();
		assertEquals(false, i.isOverlappingInterval(i1, i2));
		assertEquals(true, i.isOverlappingInterval(i1, i3));
		assertEquals(true, i.isOverlappingInterval(i1, i4));
		assertEquals(true, i.isOverlappingInterval(i1, i5));
		assertEquals(true, i.isOverlappingInterval(i1, i6));
		assertEquals(true, i.isOverlappingInterval(i1, i7));
		assertEquals(true, i.isOverlappingInterval(i1, i8));
		assertEquals(true, i.isOverlappingInterval(i1, i9));
		assertEquals(true, i.isOverlappingInterval(i1, i10));
		assertEquals(true, i.isOverlappingInterval(i1, i11));
		assertEquals(true, i.isOverlappingInterval(i1, i12));
		assertEquals(false, i.isOverlappingInterval(i1, i13));
	}
	
	@Test
	public void testMaxOverlappingSubInterval1() throws Exception {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 5));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(3, 7));
		intervals.add(new Interval(4, 8));
		intervals.add(new Interval(5, 9));
		intervals.add(new Interval(6, 10));
		intervals.add(new Interval(7, 11));
		intervals.add(new Interval(8, 12));
		Intervals i = new Intervals();
		Interval result = i.maxOverlappingSubInterval(intervals);
		assertEquals(5, result.getLow());
		assertEquals(5, result.getHigh());
	}
	@Test
	public void testMaxOverlappingSubInterval2() throws Exception {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 5));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(3, 7));
		intervals.add(new Interval(4, 8));
		//intervals.add(new Interval(5, 9));
		intervals.add(new Interval(6, 10));
		intervals.add(new Interval(7, 11));
		intervals.add(new Interval(8, 12));
		Intervals i = new Intervals();
		Interval result = i.maxOverlappingSubInterval(intervals);
		/*
		 *		 X X
		 * 1 2 3 4 5 6 7 8 9 10 11 12
		 * x x x x x
		 *   x x x x x
		 *     x x x x x
		 *       x x x x x
		 *           x x x x x
		 *             x x x x x
		 *               x x x x x
		 */
		assertEquals(4, result.getLow());
		assertEquals(5, result.getHigh());
	}

	@Test
	public void testMaxOverlappingSubInterval3() throws Exception {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 5));
//		intervals.add(new Interval(2, 6));
//		intervals.add(new Interval(3, 7));
//		intervals.add(new Interval(4, 8));
//		intervals.add(new Interval(5, 9));
//		intervals.add(new Interval(6, 10));
//		intervals.add(new Interval(7, 11));
		intervals.add(new Interval(8, 12));
		Intervals i = new Intervals();
		/*
		 *		 
		 * 1 2 3 4 5 6 7 8 9 10 11 12
		 * x x x x x
		 *               x x x x x
		 */
		Interval result = i.maxOverlappingSubInterval(intervals);
		assertEquals(1, result.getLow());
		assertEquals(5, result.getHigh());
	}

	@Test
	public void testMaxOverlappingSubInterval4() throws Exception {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 6));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(3, 7));
//		intervals.add(new Interval(4, 8));
//		intervals.add(new Interval(5, 9));
		intervals.add(new Interval(6, 10));
		intervals.add(new Interval(6, 11));
		intervals.add(new Interval(8, 12));
		Intervals i = new Intervals();
		/*
		 *		 X X
		 * 1 2 3 4 5 6 7 8 9 10 11 12
		 * x x x x x x
		 *   x x x x x
		 *     x x x x x
		 *           x x x x x
		 *           x x x x x x
		 *               x x x x x
		 */
		Interval result = i.maxOverlappingSubInterval(intervals);
		assertEquals(6, result.getLow());
		assertEquals(6, result.getHigh());
	}

		@Test
	public void testMaxOverlappingSubInterval5() throws Exception {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 6));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(3, 7));
//		intervals.add(new Interval(4, 8));
//		intervals.add(new Interval(5, 9));
		intervals.add(new Interval(6, 10));
		intervals.add(new Interval(7, 11));
		intervals.add(new Interval(8, 12));
		intervals.add(new Interval(13, 13));
		intervals.add(new Interval(13, 13));
		intervals.add(new Interval(13, 13));
		intervals.add(new Interval(13, 13));
		intervals.add(new Interval(13, 13));
		intervals.add(new Interval(13, 13));
		intervals.add(new Interval(13, 13));
		intervals.add(new Interval(13, 13));
		Intervals i = new Intervals();
		/*
		 *		 X X
		 * 1 2 3 4 5 6 7 8 9 10 11 12 13
		 * x x x x x x
		 *   x x x x x
		 *     x x x x x
		 *           x x x x x
		 *             x x x x x
		 *               x x x x x
		 *                             x
		 *                             x
		 *                             x
		 *                             x
		 *                             x
		 *                             x
		 *                             x
		 *                             x
		 */
		Interval result = i.maxOverlappingSubInterval(intervals);
		assertEquals(13, result.getLow());
		assertEquals(13, result.getHigh());
	}
}
