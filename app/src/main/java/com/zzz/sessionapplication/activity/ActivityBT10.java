package com.zzz.sessionapplication.activity;

import android.os.Bundle;
import android.util.Pair;
import android.widget.Button;
import android.widget.RatingBar;
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

public class ActivityBT10 extends AppCompatActivity {
  private TextView tvRating;
  private RatingBar ratingBar;
  private Button btnExit;
  private TextView tvReply;
  private final List<Pair<Float, String>> ratingReply =
      List.of(
          Pair.create(
              0.5F,
              "Che chắn kỹ quá, mờ mờ ảo ảo không "
                  + "thấy được nội dung chính. Che từ trên xuống dưới thế này thì anh biết 'chấm điểm' thế nào bây giờ? Đề nghị gỡ bỏ filter."),
          Pair.create(
              1F,
              "Có cố gắng nhưng còn 'chay' quá, toàn nắm tay với hôn má thì bao giờ mới lên đỉnh... "
                  + "cao của tình yêu được? Cần thêm chút 'gia vị' giật gân nhé em."),
          Pair.create(
              1.5F,
              "Nhìn cũng giống 'bản gốc' (crush trong mộng của anh) đấy, "
                  + "nhưng diễn xuất còn hơi đơ. Anh cần một màn nhập vai sâu sắc và bạo dạn hơn thế này."),
          Pair.create(
              2F,
              "Mỗi lần em xuất hiện là tim anh đập loạn nhịp, người ngợm nóng bừng như núi lửa phun trào. "
                  + "Em là một 'thảm họa' ngọt ngào khiến anh mất kiểm soát cơ thể."),
          Pair.create(
              2.5F,
              "Nội dung bắt đầu có chiều sâu và nhiều "
                  + "'vùng đất mới' để khai phá. Càng đi sâu vào chi tiết càng thấy lôi cuốn, nhưng anh vẫn chưa tìm được 'kho báu' cuối cùng."),
          Pair.create(
              3F,
              "Rất kịch tính! Kỹ năng điêu luyện, nhịp điệu dồn dập, va chạm chan chát. "
                  + "Anh và em phối hợp ăn ý như hai diễn viên stunt hạng A, nhưng hơi nhanh hết pin, cần tăng thời lượng phát sóng."),
          Pair.create(
              3.5F,
              "Kịch bản kinh điển! Anh chỉ đến kiểm tra 'đường ống' "
                  + "hoặc giao 'bánh' thôi mà em cứ làm khó anh bằng mấy bộ đồ thiếu vải thế này. Rất biết cách tạo tình huống kích thích!."),
          Pair.create(
              4F,
              "Hôm nay em rất ngoan, tiếp thu bài học rất nhanh, thực hành bài tập 'nộp bài sớm' cực kỳ xuất sắc. "
                  + "Anh chấm em điểm 9, còn 1 điểm tối nay về 'bổ túc' thêm lý thuyết giường chiếu nhé."),
          Pair.create(
              4.5F,
              "Quá bạo! Em làm chủ hoàn toàn thế trận, dắt mũi anh từ hiệp này sang hiệp khác. "
                  + "Sợi xích tình yêu của em trói chặt anh rồi, anh tự nguyện đầu hàng và xin được 'hành hạ' tiếp.."),
          Pair.create(
              5F,
              "Tuyệt phẩm không che! Full HD, không góc chết, âm thanh sống động, hình ảnh mướt mát."
                  + " Xem xong chỉ muốn 'replay' cả đêm không ngừng nghỉ. Em chính là ảnh hậu xuất sắc nhất trong lòng anh!."));

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_bt10);
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
    tvRating = findViewById(R.id.tv_rating_bt10);
    tvReply = findViewById(R.id.tv_rating_reply_bt10);
    tvRating.setText("Rating");
    btnExit = findViewById(R.id.btn_exit_bt10);
    btnExit.setText(Constant.EXIT);
    ratingBar = findViewById(R.id.ratingBar_bt5);
  }

  private void act() {
    btnExit.setOnClickListener(v -> finish());
    ratingBar.setOnRatingBarChangeListener(
        (ratingBar, rating, fromUser) -> {
          Pair<Float, String> reply =
              ratingReply.stream().filter(p -> p.first == rating).findFirst().orElse(null);
          if (reply == null) return;
          tvRating.setText(String.format("%s", StringUtil.cast(reply.first)));
          tvReply.setText(reply.second);
        });
  }
}
