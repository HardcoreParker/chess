package piece;

import java.util.ArrayList;

import orchestration.Space;

public interface ThreatenSeparateFromMove {

	public ArrayList<Space> calculateSpacesPieceCanThreaten(Space origin);
	
}
