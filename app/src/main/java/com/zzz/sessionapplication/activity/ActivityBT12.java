package com.zzz.sessionapplication.activity;

import android.os.Bundle;
import android.util.Pair;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.zzz.sessionapplication.R;
import com.zzz.sessionapplication.constant.Constant;
import com.zzz.sessionapplication.util.StringUtil;
import java.util.List;

public class ActivityBT12 extends AppCompatActivity {
  private ImageView imgLogo;
  private Button btnExit;
  private TextView tvResult;
  private TextView tvReply;
  private ProgressBar progressBar;
  private static final String POINT = "Point";
  private static final List<Pair<Integer, String>> POINT_REPLY =
      List.of(
          Pair.create(
              10,
              "Nội dung kín cổng cao tường, muốn thấy gì là phải đi 'điều tra', "
                  + "'mật phục' mệt mỏi. Gợi cảm một cách quá bí ẩn, anh đề nghị chúng ta nên công khai nội dung, bớt che giấu lại."),
          Pair.create(
              20,
              "Thả thính một chút rồi thôi, cắt cảnh ngay đoạn gay cấn! Em làm anh 'lên mood'"
                  + " xong lại bắt anh đợi tập sau. Kiểu này là hành hạ người xem chứ yêu thương gì!"),
          Pair.create(
              30,
              "Rất trong sáng và đáng yêu, nhưng chúng ta qua cái tuổi nắm tay đỏ mặt rồi em ơi. "
                  + "Anh cần một bước chuyển mình từ 'học sinh gương mẫu' sang 'nữ chính nổi loạn' nhé."),
          Pair.create(
              40,
              "Bắt đầu vào form rồi đấy! Kịch bản kinh điển, "
                  + "em vừa mở cửa là anh đã thấy 'nóng' trong người. Bối cảnh rất kích thích, chỉ chờ hai bên lao vào 'ký hợp đồng' thôi."),
          Pair.create(
              50,
              "Gay cấn, dồn dập, va chạm vật lý cực kỳ mãn nhãn! Kỹ xảo (bộ đồ của em) rất ra gì và này nọ. "
                  + "Anh và em phối hợp làm quả 'stunt' này ra trò đấy, nhưng cần thêm chút chiều sâu tâm hồn... và thể xác."),
          Pair.create(
              60,
              "Góc máy chân thực, mang lại cảm giác nhập vai đỉnh cao! Mọi ánh mắt, bờ môi của em đều hướng thẳng vào camera (là anh). "
                  + "Trải nghiệm này quá sống động, anh không thể rời mắt được một giây."),
          Pair.create(
              70,
              "Em nhập vai xuất sắc quá! Hôm nay là thư ký, ngày mai là 'y tá', làm anh không biết đường nào mà lần. "
                  + "Sự quyến rũ mang tính chiến thuật này làm anh hoàn toàn bị hạ gục."),
          Pair.create(
              80,
              "Quá bạo lực (về mặt cảm xúc)! Em hoàn toàn làm chủ thế trận, ra lệnh bằng ánh mắt và bắt anh phải phục tùng. "
                  + "Sợi xích tình yêu này quá chặt rồi, nhưng anh thích bị em 'hành hạ' kiểu này."),
          Pair.create(
              90,
              "Tuyệt phẩm nhân gian! Không góc chết, không che chắn, mướt mát từ đầu đến chân. "
                  + "Âm thanh sống động (tiếng thở của em), hình ảnh sắc nét. Bộ phim này xứng đáng nhận giải Oscar ngành công nghiệp 18+!"),
          Pair.create(
              100,
              "Cạn lời! Xem xong chỉ muốn bấm 'Replay' liên tục cho đến sáng. Em không còn là diễn viên nữa, em là 'đạo diễn' cuộc đời anh rồi. "
                  + "Đêm nay chúng ta quay phần 2, phần 3 luôn nhé, không cho em nghỉ!"));

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_bt12);
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
    imgLogo = findViewById(R.id.img_logo_bt12);
    btnExit = findViewById(R.id.btn_exit_bt12);
    btnExit.setText(Constant.EXIT);
    tvResult = findViewById(R.id.tv_result_bt12);
    tvResult.setText(POINT);
    tvReply = findViewById(R.id.tv_reply_bt12);
    progressBar = findViewById(R.id.progressbar_bt12);
  }

  private void act() {
    btnExit.setOnClickListener(v -> finish());
    imgLogo.setOnClickListener(
        v -> {
          if (progressBar.getMax() == progressBar.getProgress()) {
            progressBar.setProgress(0);
            tvResult.setText(POINT);
            tvReply.setText(null);
          } else {
            int pointProgress = progressBar.getProgress() + 10;
            Pair<Integer, String> reply =
                POINT_REPLY.stream().filter(p -> p.first == pointProgress).findFirst().orElse(null);
            if (reply == null) return;
            tvResult.setText(StringUtil.cast(pointProgress));
            progressBar.setProgress(pointProgress);
            tvReply.setText(reply.second);
          }
        });
  }
}
