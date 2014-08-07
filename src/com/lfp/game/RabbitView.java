package com.lfp.game;

import com.lfp.test.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class RabbitView extends View {

	public float bitmapX;
	public float bitmapY;
	
	public RabbitView(Context context) {
		super(context);
		bitmapX=50;
		bitmapY=50;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		Paint paint = new Paint();
		Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.rabbit);
		canvas.drawBitmap(bitmap, bitmapX, bitmapY,paint);
		if(bitmap.isRecycled()){
			bitmap.recycle();
		}
	}
}
