package com.zzz.sessionapplication.activity;

import android.os.Bundle;
import android.util.Pair;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.zzz.sessionapplication.R;
import com.zzz.sessionapplication.constant.Constant;
import java.util.List;
import java.util.function.Predicate;

public class ActivityBT11 extends AppCompatActivity {
  private static final String SEEKBAR = "Seekbar";
  private static final List<Pair<Predicate<Integer>, String>> pointReply =
      List.of(
          Pair.create(
              progress -> progress >= 0 && progress <= 25,
              "Mức độ này giống như mấy bộ phim tình cảm nhưng gắn mác 18+ vì có quá nhiều cảnh... "
                  + "cởi bớt cúc áo. Em cứ lượn qua lượn lại, thả thính nửa kín nửa hở làm anh xem mà tức cái lồng ngực. Nội dung thì ít mà kịch tính (drama) "
                  + "thì nhiều, cứ bắt anh phải chờ đợi. "
                  + "Đề nghị tăng tốc độ tua phim chứ 'khán giả' ngồi dưới đang nóng lòng lắm rồi nhé!"),
          Pair.create(
              progress -> progress > 25 && progress <= 50,
              "Góc "
                  + "máy thứ nhất cực kỳ chân thực! Phân đoạn này giống như kịch bản kinh điển: "
                  + "Anh ship pizza/sửa ống nước tới và em đón cửa với bộ trang phục không thể thiếu vải hơn. Bắt đầu có những cú va chạm trực diện, "
                  + "góc nhìn cận cảnh làm tim anh đập 120 nhịp/phút. Diễn xuất rất tự nhiên, "
                  + "phối hợp ăn ý, nhưng vẫn còn hơi mang tính 'thủ tục', chưa có cú twist nào thực sự bùng nổ."),
          Pair.create(
              progress -> progress > 50 && progress <= 75,
              "GQuá dữ dội! Đoạn này là chuyển sang phim hành động bom tấn Hollywood rồi. "
                  + "Kỹ xảo (kỹ năng) của em quá điêu luyện, nhịp điệu dồn dập, âm thanh sống động từ Dolby Surround cho đến vòm họng. "
                  + "Anh và em bay lượn từ phòng khách, phòng tắm cho đến giường ngủ như có phép thuật viễn tưởng. "
                  + "Xem tới khúc này là anh bắt đầu thấy thở dốc, 'mất kiểm soát' hệ thống và suýt chút nữa là hết pin giữa chừng."),
          Pair.create(
              progress -> progress > 75,
              "Cảnh báo cháy màn hình! Đạt mốc 100% full HD không che, không góc chết. "
                  + "Em chính là 'Ảnh hậu' xuất sắc nhất lịch sử điện ảnh trong lòng anh. Sự táo bạo, "
                  + "hoang dại và những tiếng 'nấc cụt' vì sung sướng làm anh chỉ muốn bấm nút Replay (làm lại hiệp nữa) cả đêm không cho phim kết thúc. "
                  + "Bộ phim này xứng đáng nhận giải Oscar cho hạng mục 'Kịch bản khiến khán giả mất nhiều sức lực nhất'!"));
  private Button btnExit;
  private SeekBar seekBar;
  private TextView tvSeekBar;
  private TextView tvPointReply;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_bt11);
    init();
    act();
    ViewCompat.setOnApplyWindowInsetsListener(
        findViewById(R.id.main),
        (v, insets) -> {
          Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
          v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
          return insets;
        });
  }

  private void init() {
    btnExit = findViewById(R.id.btn_exit_bt11);
    btnExit.setText(Constant.EXIT);
    seekBar = findViewById(R.id.seekbar_bt11);
    tvSeekBar = findViewById(R.id.tv_seekbar_bt11);
    tvSeekBar.setText(SEEKBAR);
    tvPointReply = findViewById(R.id.tv_reply_bt11);
  }

  private void act() {
    btnExit.setOnClickListener(v -> finish());
    seekBar.setOnSeekBarChangeListener(
        new SeekBar.OnSeekBarChangeListener() {
          @Override
          public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            for (var reply : pointReply) {
              Predicate<Integer> predicate = reply.first;
              if (predicate.test(progress)) {
                tvSeekBar.setText(String.format("%s: %s", SEEKBAR, progress));
                tvPointReply.setText(reply.second);
                return;
              }
            }
          }

          @Override
          public void onStartTrackingTouch(SeekBar seekBar) {}

          @Override
          public void onStopTrackingTouch(SeekBar seekBar) {}
        });
  }
}
