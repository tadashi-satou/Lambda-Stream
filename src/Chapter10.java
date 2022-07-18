import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Chapter10 {
	public static void main(String[] args) throws Exception {
		List<Task> list = new ArrayList<>();
		list.add(new Task(LocalDate.of(2021, 10, 21), "牛乳を買う", true));
		list.add(new Task(LocalDate.of(2021, 9, 15), "○○社面接", false));
		list.add(new Task(LocalDate.of(2021, 12, 4), "手帳を買う", true));
		list.add(new Task(LocalDate.of(2021, 8, 10), "散髪に行く", false));
		list.add(new Task(LocalDate.of(2021, 11, 9), "スクールの課題を解く", false));
		// Stream APIとラムダ式を使って記述
		// 要素の個数をカウント
		long c1 = list.stream() // Streamを生成
				.filter(f -> f.isDone() == false) //中間操作1: タスクが未完了(false)のものを抽出
				.count();//抽出したものをカウント
		System.out.println("未完了のタスクの個数は" + c1);
		System.out.println("【未完了のタスクを昇順に並び替えて一覧表示】");
		//未完了のタスクを昇順に並び替えて一覧表示
		list.stream() // Streamを生成
				.filter(f -> f.isDone() == false) // 中間操作1: 個数が10個以下のものを抽出
				.sorted() // 中間操作3: 個数の少ない順に並び替え
				.forEach(System.out::println); // 終端操作: 標準出力		
	}
}