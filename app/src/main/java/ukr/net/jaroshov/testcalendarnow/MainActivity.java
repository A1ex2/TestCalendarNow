package ukr.net.jaroshov.testcalendarnow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import ukr.net.jaroshov.testcalendarnow.my_calendar.CalendarPickerView;
import ukr.net.jaroshov.testcalendarnow.my_calendar.SubTitle;

public class MainActivity extends AppCompatActivity {
    CalendarPickerView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.MONTH, 6);

        final Calendar lastYear = Calendar.getInstance();
        lastYear.add(Calendar.MONTH, -6);

        calendar = findViewById(R.id.calendar_view);
        ArrayList<Integer> list = new ArrayList<>();
        //list.add(2);

        calendar.deactivateDates(list);
        ArrayList<Date> arrayList = new ArrayList<>();
        try {
            SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");

            String strdate = "22-6-2022";
            String strdate2 = "26-6-2022";

            Date newdate = dateformat.parse(strdate);
            Date newdate2 = dateformat.parse(strdate2);
            arrayList.add(newdate);
            arrayList.add(newdate2);

            String strdate3 = "20-6-2022";
            Date newdate3 = dateformat.parse(strdate3);
            arrayList.add(newdate3);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        calendar.init(lastYear.getTime(), nextYear.getTime(), new SimpleDateFormat("MMMM, YYYY", Locale.getDefault()))
                .inMode(CalendarPickerView.SelectionMode.SINGLE)
                .withDeactivateDates(list)
                .withSubTitles(getSubTitles())
//                .withHighlightedDates(arrayList)
                .withSelectedDate(Calendar.getInstance().getTime());

        calendar.scrollToDate(new Date());
        calendar.setCellClickInterceptor(new CalendarPickerView.CellClickInterceptor() {
            @Override
            public boolean onCellClicked(Date date) {
                Toast.makeText(MainActivity.this, "list " + date.toString(), Toast.LENGTH_LONG).show();
                return false;
            }
        });


//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "list " + calendar.getSelectedDates().toString(), Toast.LENGTH_LONG).show();
//            }
//        });
    }

    private ArrayList<SubTitle> getSubTitles() {
        final ArrayList<SubTitle> subTitles = new ArrayList<>();
//        final Calendar tmrw = Calendar.getInstance();
//        tmrw.add(Calendar.DAY_OF_MONTH, 1);
        //subTitles.add(new SubTitle(Calendar.getInstance().getTime(), "—"));

        try {
            SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");

            String strdate = "22-6-2022";
            String strdate2 = "26-6-2022";
            String strdate3 = "20-6-2022";
            String strdate4 = "21-6-2022";

            Date newdate = dateformat.parse(strdate);
            Date newdate2 = dateformat.parse(strdate2);
            Date newdate3 = dateformat.parse(strdate3);
            Date newdate4 = dateformat.parse(strdate4);

            subTitles.add(new SubTitle(newdate, "5"));
            subTitles.add(new SubTitle(newdate2, "2"));
            subTitles.add(new SubTitle(newdate3, "10"));
            subTitles.add(new SubTitle(newdate4, "10"));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return subTitles;
    }
}