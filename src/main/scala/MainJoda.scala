object Kalendarz {

	import com.github.nscala_time.time.Imports._
	import org.joda.time.Days
	import java.util.Locale

	def main(args: Array[String]): Unit = {
		val locale = new Locale("pl","pl");
		val teraz = DateTime.now
		val wigilia = (new DateTime)
			.withYear(2016)
			.withMonthOfYear(12)
			.withDayOfMonth(24)

		val doWigilii = Days.daysBetween(teraz, wigilia).getDays

		println(s"Do Wigilii pozostało $doWigilii dni")

		// bonus: jaki dzień będzie za 200 dni?
		val terazPlus100 = teraz + 100.days
		println(s"za 100 dni będzie ${terazPlus100.dayOfWeek().getAsText(locale)}")

	}
}
