//SNAKE VIEW
package com.example.nnelanut.snakeapplication.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.NinePatchDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.nnelanut.snakeapplication.R;
import com.example.nnelanut.snakeapplication.enums.TileType;

/**
 * Created by 123 on 12/8/2017.
 */

public class SnakeView extends View {
    private Paint mPaint = new Paint();
    private TileType snakeViewMap[][];

    public SnakeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setSnakeViewMap(TileType[][] map) { this.snakeViewMap = map; }

    //This method paints the tiles on the grid.

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(snakeViewMap != null) {
            float tileSizeX = canvas.getWidth() / snakeViewMap.length;
            float tileSizeY = canvas.getHeight() / snakeViewMap[0].length;

            float circleSize = Math.min(tileSizeX, tileSizeY) / 2;
            float squareSize = Math.min(tileSizeX, tileSizeY) / 2;

            for (int x = 0; x < snakeViewMap.length; x++) {
                for (int y = 0; y < snakeViewMap[x].length; y++) {
                    int n = 0;
                    int w = 0;
                    int h = 0;
                    int t = 0;
                    int a = 0;

                    switch (snakeViewMap[x][y]) {

                        case Nothing:
                            n = 1;
                            mPaint.setColor(Color.TRANSPARENT);
                            break;
                        case Wall:
                            w = 1;
                            mPaint.setColor(Color.BLUE);
                            break;
                        case SnakeHead:
                            h = 1;
                            mPaint.setColor(Color.GREEN);
                            break;
                        case SnakeTail:
                            t = 1;
                            mPaint.setColor(Color.GREEN);
                            break;
                        case Apple:
                            a = 1;
                            mPaint.setColor(Color.RED);
                            break;
                    }

                    float xCord = x * tileSizeX + tileSizeX / 2f + circleSize / 2;
                    float yCord = y * tileSizeY + tileSizeY /2f + circleSize / 2;
                    RectF rectF = new RectF(xCord - squareSize, yCord - squareSize, xCord + squareSize, yCord + squareSize);

                    int xC = (int)(Math.round(xCord));
                    int yC = (int)(Math.round(yCord));
                    int sS = (int)(Math.round(squareSize));
                    Rect rect = new Rect(xC - sS, yC - sS, xC + sS, yC + sS);

                    if(n == 1) {
                        canvas.drawRect( rectF, mPaint );
                    } else if(w == 1) {
                        canvas.drawRect( rectF, mPaint );
                    } else if(h == 1) {
                        //canvas.drawCircle(x * tileSizeX + tileSizeX / 2f + circleSize / 2, y * tileSizeY + tileSizeY /2f + circleSize / 2, circleSize, mPaint);

                        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.snake_head_south);
                        canvas.drawBitmap( b, null, rect, null );
                    } else if(t == 1) {
                        //canvas.drawRect( rectF, mPaint );

                        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.snake_body_ud);
                        canvas.drawBitmap( b, null, rect, null );
                    } else if( a == 1) {
                        //canvas.drawCircle(x * tileSizeX + tileSizeX / 2f + circleSize / 2, y * tileSizeY + tileSizeY /2f + circleSize / 2, circleSize, mPaint);

                        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.apple);
                        canvas.drawBitmap( b, null, rect, null );
                    }

                    //canvas.drawBitmap();
                    //canvas.drawRect( xCord - squareSize, yCord - squareSize, xCord + squareSize, yCord + squareSize, mPaint );
                    //canvas.drawCircle(x * tileSizeX + tileSizeX / 2f + circleSize / 2, y * tileSizeY + tileSizeY /2f + circleSize / 2, circleSize, mPaint);
                }
            }
        }
    }
}
