package com.lfp.mediaPlayer;

import com.lfp.test.R;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MediaPlayerActivity extends Activity implements
		SurfaceHolder.Callback {

	private TextView textView_msg;
	// 创建MediaPlayer对象
	private MediaPlayer mMediaPlayer1;
	// SurfaceView对象作为Layout上的输出接口
	private SurfaceView msurfaceView1;
	// 以SurfaceHolder来控制SurfaceView
	private SurfaceHolder mSurfaceHolder1;
	// 播放控制按钮
	private Button button_play;
	private Button button_pause;
	private Button button_stop;
	private Button button_reset;

	// MediaPlayer暂停flag
	private boolean bIsPaused = false;
	// mediaPlayer被释放的flag
	private boolean bIsReleased = false;
	// 影片位置
	private String strVideoPath = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mediaplayer);

		textView_msg = (TextView) findViewById(R.id.textView_msg);

		// 设置系统PixelFormae为UNKONWN
		getWindow().setFormat(PixelFormat.UNKNOWN);

		msurfaceView1 = (SurfaceView) findViewById(R.id.surfaceView1);
		// 设置surfaceHolder为Layout SurfaceView全屏幕
		mSurfaceHolder1 = (msurfaceView1.getHolder());
		mSurfaceHolder1.addCallback(this);
		// 原影片大小
		// mSurfaceHolder1.setFixedSize(111, 111);
		// mSurfaceHolder1.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		// 控制播放按钮
		button_play = (Button) findViewById(R.id.button_play);
		button_pause = (Button) findViewById(R.id.button_pause);
		button_stop = (Button) findViewById(R.id.button_stop);
		button_reset = (Button) findViewById(R.id.button_reset);
		button_play.setOnClickListener(new ButtonPlayListener());
		button_pause.setOnClickListener(new ButtonPauseListener());
		button_stop.setOnClickListener(new ButtonStopListener());
		button_reset.setOnClickListener(new ButtonResetListener());
		// 设置测试影片位置
		strVideoPath = "/storage/extSdCard/1.mp4";

	}

	class ButtonPlayListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			playVideo(strVideoPath);
		}

	}

	class ButtonPauseListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if (mMediaPlayer1 != null) {
				if (!bIsReleased) {
					if (!bIsPaused) {
						mMediaPlayer1.pause();
						bIsPaused = true;
						textView_msg.setText(R.string.pause);
					} else {
						mMediaPlayer1.start();
						bIsPaused = false;
						textView_msg.setText(R.string.play);
					}
				}
			}
		}

	}

	class ButtonStopListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if (mMediaPlayer1 != null && !bIsReleased) {
				mMediaPlayer1.stop();
				mMediaPlayer1.release();
				bIsReleased = true;
				textView_msg.setText(R.string.stop);
			}
		}

	}

	class ButtonResetListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if (mMediaPlayer1 != null && !bIsReleased) {
				mMediaPlayer1.seekTo(0);
			}
		}

	}

	// 自定义播放影片函数
	private void playVideo(String strPath) {
		mMediaPlayer1 = new MediaPlayer();
		mMediaPlayer1.setAudioStreamType(AudioManager.STREAM_MUSIC);
		// 设置Video影片以SurfaceHolder播放
		mMediaPlayer1.setDisplay(mSurfaceHolder1);
		try {
			mMediaPlayer1.setDataSource(strPath);
		} catch (Exception e) {
			textView_msg.setText("setDataSource Exception:" + e.toString());
			e.printStackTrace();
		}
		try {
			mMediaPlayer1.prepare();
		} catch (Exception e) {
			textView_msg.setText("prepare Exception:" + e.toString());
			e.printStackTrace();
		}
		mMediaPlayer1.start();
		bIsReleased = false;
		textView_msg.setText(R.string.play);
		mMediaPlayer1
				.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

					@Override
					public void onCompletion(MediaPlayer mp) {
						// TODO Auto-generated method stub
						textView_msg.setText(R.string.stop);
					}
				});
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}

}
