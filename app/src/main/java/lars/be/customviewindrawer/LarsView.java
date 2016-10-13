package lars.be.customviewindrawer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by brandonstark on 13/10/16.
 */

public class LarsView extends View {

    private int squareColor;
    private int labelColor;
    private String squareText;

    private Paint squarePaint;

    public LarsView(Context context, AttributeSet attrs) {
        super(context, attrs);

        squarePaint = new Paint();
        TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LarsView, 0 ,0);

        squareText = styledAttributes.getString(R.styleable.LarsView_squareLabel);
        squareColor = styledAttributes.getInteger(R.styleable.LarsView_labelColor, 0);
        labelColor = styledAttributes.getInteger(R.styleable.LarsView_labelColor, 0);

        styledAttributes.recycle();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        squarePaint.setStyle(Paint.Style.FILL);
        squarePaint.setAntiAlias(true);
        squarePaint.setColor(squareColor);

        canvas.drawRect(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight(), squarePaint);
        squarePaint.setColor(labelColor);
        squarePaint.setTextAlign(Paint.Align.CENTER);
        squarePaint.setTextSize(50);

        canvas.drawText(squareText, this.getMeasuredWidth()/2, this.getMeasuredHeight()/2, squarePaint);
    }

    public int getSquareColor() {
        return squareColor;
    }

    public void setSquareColor(int squareColor) {
        this.squareColor = squareColor;
        invalidate();
        requestLayout();
    }

    public int getLabelColor() {
        return labelColor;
    }

    public void setLabelColor(int labelColor) {
        this.labelColor = labelColor;
        invalidate();
        requestLayout();
    }

    public String getSquareText() {
        return squareText;
    }

    public void setSquareText(String squareText) {
        this.squareText = squareText;
        invalidate();
        requestLayout();
    }
}
