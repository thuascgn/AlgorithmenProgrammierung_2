package objects;

class InvaderWorld extends AbstractWorld{
	int COLS = 9;
	int ROWS = 8;
	int[][] invader = new int[][]{
		{0,1,0,0,0,0,0,1,0},
		{0,0,1,0,0,0,1,0,0},
		{0,0,1,1,1,1,1,0,0},
		{0,1,1,0,1,0,1,1,0},
		{1,1,1,1,1,1,1,1,1},
		{1,0,1,1,1,1,1,0,1},
		{1,0,1,0,0,0,1,0,1},
		{0,0,1,1,0,1,1,0,0}
	};
	InvaderWorld(int nx, int ny) {
		super(nx, ny);
		int onx = (nx/2)-4;
		int ony = (ny/2)-4;
		for (int i=0;i<ROWS; i++){
			for (int j=0; j<COLS;j++) {
				if (invader[i][j] == 1) {
					set(onx+j, ony+i, BlackToken.instance());
				}
			}
		}
		
	}

}
