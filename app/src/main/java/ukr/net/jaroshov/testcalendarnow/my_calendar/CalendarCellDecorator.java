package ukr.net.jaroshov.testcalendarnow.my_calendar;

import java.util.Date;

public interface CalendarCellDecorator {
  void decorate(CalendarCellView cellView, Date date);
}
