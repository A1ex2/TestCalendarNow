package ukr.net.jaroshov.testcalendarnow.my_calendar;

import android.graphics.Color;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import ukr.net.jaroshov.testcalendarnow.R;

public class DefaultDayViewAdapter implements DayViewAdapter {
    @Override
    public void makeCellView(CalendarCellView parent) {

        TextView subTitleTextView = new TextView(
            new ContextThemeWrapper(parent.getContext(), R.style.CalendarCell_SubTitle));
        subTitleTextView.setDuplicateParentStateEnabled(true);
        subTitleTextView.setGravity(Gravity.BOTTOM);

        LinearLayout l = new LinearLayout(parent.getContext());
        l.addView(subTitleTextView);
        l.setOrientation(LinearLayout.HORIZONTAL);
        l.setGravity(Gravity.RIGHT);
        parent.addView(l);

        TextView textView = new TextView(
            new ContextThemeWrapper(parent.getContext(), R.style.CalendarCell_CalendarDate));
        textView.setDuplicateParentStateEnabled(true);
        parent.addView(textView);

        parent.setDayOfMonthTextView(textView);
        parent.setSubTitleTextView(subTitleTextView);
    }
}
