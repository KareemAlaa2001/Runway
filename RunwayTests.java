import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RunwayTests
{
	private boolean obstacleEqual(ObstacleData a, ObstacleData b)
	{
		return (a.position == b.position) && (a.maxHeight == b.maxHeight);
	}

	@Test
    public void testRunwayNamingConventions()
    {
    	Runway rw = new Runway(33, new RunwayData(306, 3902, 3902, 3902, 3595), new RunwayData(0, 3884, 3962, 3884, 3884));

        assertTrue(rw.getRunL().getName().equals("33L"));
        assertTrue(rw.getRunR().getName().equals("15R"));

    	Runway rw2 = new Runway(1, new RunwayData(306, 3902, 3902, 3902, 3595), new RunwayData(0, 3884, 3962, 3884, 3884));

        assertTrue(rw2.getRunL().getName().equals("01L"));
        assertTrue(rw2.getRunR().getName().equals("19R"));

    	Runway rw3 = new Runway(13, new RunwayData(306, 3902, 3902, 3902, 3595), new RunwayData(0, 3884, 3962, 3884, 3884));

        assertTrue(rw3.getRunL().getName().equals("13L"));
        assertTrue(rw3.getRunR().getName().equals("31R"));
    }

	@Test
    public void testAddingObstacles()
    {
    	Runway rw = new Runway(33, new RunwayData(306, 3902, 3902, 3902, 3595), new RunwayData(0, 3884, 3962, 3884, 3884));
    	ObstacleData l = new ObstacleData(100, 45);
    	ObstacleData r = new ObstacleData(-20, 13);
    	rw.addObstacleL(l);
    	rw.addObstacleR(r);

        assertTrue(obstacleEqual(rw.getRunL().getObstacles().get(0), l));
        assertTrue(obstacleEqual(rw.getRunR().getObstacles().get(0), r));
    }
}