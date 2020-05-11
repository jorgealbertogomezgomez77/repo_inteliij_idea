/**
import java.util.Random;
import static java.nio.file.Files.size;
import static javax.swing.SwingConstants.CENTER;

public class Tetromino {
    int shape[][] = new int[4][2];
    int col = 0;

    public Tetromino() {
        Random r = new Random();
        int col = r.nextInt(8);
        if (col == 1) {
            shape[1][0] = 1;
            shape[2][0] = -1;
            shape[3][0] = -2;
        } else if (col == 2) {
            shape[1][0] = 1;
            shape[2][0] = -1;
            shape[3][0] = -1;
            shape[3][1] = -1;
        } else if (col == 3) {
            shape[1][0] = 1;
            shape[2][0] = -1;
            shape[3][0] = 1;
            shape[3][1] = -1;
        } else if (col == 4) {
            shape[1][0] = 1;
            shape[2][1] = 1;
            shape[3][0] = 1;
            shape[3][1] = 1;
        } else if (col == 5) {
            shape[1][0] = -1;
            shape[2][1] = -1;
            shape[3][0] = 1;
            shape[3][1] = -1;
        } else if (col == 6) {
            shape[1][0] = 1;
            shape[2][0] = -1;
            shape[3][1] = -1;
        } else {
            shape[1][0] = 1;
            shape[2][1] = -1;
            shape[3][0] = -1;
            shape[3][1] = -1;
        }
    }

    public int getShapeX(int i) {
        return shape[i][0];
    }

    public int getShapeY(int i) {
        return shape[i][1];
    }

    public int getMaxX() {
        int i = 0;
        for (int j = 0; j < 4; j++) {
            if (shape[j][0] > shape[i][0]) {
                i = j;
            }
        }
        return shape[i][0];
    }

    public int getMaxY() {
        int i = 0;
        for (int j = 0; j < 4; j++) {
            if (shape[j][1] > shape[i][1]) {
                i = j;
            }
        }
        return shape[i][1];
    }

    public int getMinX() {
        int i = 0;
        for (int j = 0; j < 4; j++) {
            if (shape[j][0] < shape[i][0]) {
                i = j;
            }
        }
        return shape[i][0];
    }

    public int getMinY() {
        int i = 0;
        for (int j = 0; j < 4; j++) {
            if (shape[j][1] < shape[i][1]) {
                i = j;
            }
        }
        return shape[i][1];
    }

    public int getColor() {
        return col;
    }

    public void rot() {
        for (int i = 0; i < 4; i++) {
            int buf = shape[i][0];
            shape[i][0] = shape[i][1];
            shape[i][1] = -buf;
        }
    }
}

public void Main() {

    int Grid[][] = new int[10][20];
    Tetromino current = new Tetromino();
    int currentPos[] = new int[2];
    int timeBuff = 0;
    int score = 0;

    public void setup() {
        size(200, 375);
        textFont(createFont("Courier", 20));
        textAlign(CENTER, CENTER);
        current = new Tetromino();
        currentPos[0] = 4;
        currentPos[1] = 0;
    }

    public void keyPressed() {
        if (keyCode == 37) {
            boolean stop = false;
            for (int i = 0; i < 4; i++) {
                if ((current.getShapeX(i)+currentPos[0]) > 0) {
                    if ((current.getShapeX(i)+currentPos[0]) < 9 && (current.getShapeY(i)+currentPos[1]) < 19 && (current.getShapeY(i)+currentPos[1]) > 0) {
                        if (Grid[current.getShapeX(i)+currentPos[0]-1][current.getShapeY(i)+currentPos[1]] != 0)
                            stop = true;
                    }
                }
                else {
                    stop = true;
                }
            }
            if (!stop) {
                currentPos[0]--;
            }
        }

        if (keyCode == 38) {
            current.rot();
            if (current.getMinX()+currentPos[0] < 0)
                currentPos[0]-=current.getMinX()+currentPos[0];
            if (current.getMaxX()+currentPos[0] > 9)
                currentPos[0]-=current.getMaxX()+currentPos[0]-9;
            if (current.getMinY()+currentPos[1] < 0)
                currentPos[1]-=current.getMinY()+currentPos[1];
            if (current.getMaxY()+currentPos[1] > 19)
                currentPos[1]-=current.getMaxY()+currentPos[1]-19;
        }

        if (keyCode == 39) {
            boolean stop = false;
            for (int i = 0; i < 4; i++) {
                if ((current.getShapeX(i)+currentPos[0]) < 9) {
                    if ((current.getShapeX(i)+currentPos[0]) > 0 && (current.getShapeY(i)+currentPos[1]) < 19 && (current.getShapeY(i)+currentPos[1]) > 0) {
                        if (Grid[current.getShapeX(i)+currentPos[0]+1][current.getShapeY(i)+currentPos[1]] != 0)
                            stop = true;
                    }
                }
                else {
                    stop = true;
                }
            }
            if (!stop) {
                currentPos[0]++;
            }
        }

        if (keyCode == 40) {
            score++;
            currentPos[1]++;
            verifyGrid();
        }
    }

    public void draw() {
        background(0);
        noStroke();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 20; y++) {
                if (Grid[x][y] == 0)
                    fill(100);
                else if (Grid[x][y] == 1)
                    fill(50, 150, 255);
                else if (Grid[x][y] == 2)
                    fill(0, 0, 255);
                else if (Grid[x][y] == 3)
                    fill(255, 150, 0);
                else if (Grid[x][y] == 4)
                    fill(255, 255, 0);
                else if (Grid[x][y] == 5)
                    fill(100, 255, 0);
                else if (Grid[x][y] == 6)
                    fill(150, 0, 150);
                else{
                    fill(255,0,0);
                }
                rect(x*15+25, y*15+25, 13, 13);
            }
        }

        displayCurrent();
        timeBuff++;
        if (timeBuff > 20) {
            timeBuff = 0;
            currentPos[1]++;
        }
        verifyGrid();
        text("Score : "+score, 100, 345);
    }

    public void verifyGrid() {
        boolean stop = false;

        for (int i = 0; i < 4; i++) {
            if (current.getShapeY(i)+currentPos[1] < 19) {
                if (Grid[current.getShapeX(i)+currentPos[0]][current.getShapeY(i)+currentPos[1]+1] != 0) {
                    stop = true;
                }
            }
        }

        if (current.getMaxY()+currentPos[1] == 19 || stop) {
            for (int i = 0; i < 4; i++) {
                if ((current.getShapeY(i)+currentPos[1]) < 0) {
                    lost();
                }
                else {
                    Grid[(current.getShapeX(i)+currentPos[0])][(current.getShapeY(i)+currentPos[1])] = current.getColor();
                }
            }

            int count = 0;
            for (int y = 0; y < 20; y++) {
                boolean destroy = true;
                for (int x = 0; x < 10; x++) {
                    if (Grid[x][y] == 0) destroy = false;
                }
                if (destroy) {
                    count++;
                    for (int y2 = y-1; y2 > -1; y2--) {
                        for (int x = 0; x < 10; x++) {
                            Grid[x][y2+1] = Grid[x][y2];
                        }
                    }
                }
            }

            if (count > 0) {
                if (count == 1) {
                    score += 40;
                }
                else if (count == 2) {
                    score += 100;
                }
                else if (count == 3) {
                    score += 300;
                }
                else {
                    score += 1200;
                }
            }

            current = new Tetromino();
            currentPos[0] = 4;
            currentPos[1] = 0;
            displayCurrent();

            for (int i = 0; i < 4; i++) {
                if (current.getShapeY(i)+currentPos[1] < 19) {
                    if (Grid[current.getShapeX(i)+currentPos[0]][current.getShapeY(i)+currentPos[1]+1] != 0) {
                        lost();
                    }
                }
            }
        }
    }

    public void lost() {
        fill(0, 200);
        rect(0, 0, width, height);
        fill(255);
        text("Score : "+score, 100, 345);
        noLoop();
    }

    public void displayCurrent() {
        if (current.getColor() == 0) {
            fill(100);
        }
        else if (current.getColor() == 1) {
            fill(50, 150, 255);
        }
        else if (current.getColor() == 2) {
            fill(0, 0, 255);
        }
        else if (current.getColor() == 3) {
            fill(255, 150, 0);
        }
        else if (current.getColor() == 4) {
            fill(255, 255, 0);
        }
        else if (current.getColor() == 5) {
            fill(100, 255, 0);
        }
        else if (current.getColor() == 6) {
            fill(150, 0, 150);
        }
        else {
            fill(255, 0, 0);
        }

        for (int i = 0; i < 4; i++) {
            if ((current.getShapeY(i)+currentPos[1]) >= 0) {
                rect((current.getShapeX(i)+currentPos[0])*15+25, (current.getShapeY(i)+currentPos[1])*15+25, 13, 13);
            }
        }
    }
}*/