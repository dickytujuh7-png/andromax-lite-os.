package id.andromax.lite.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.KeyEvent;
import android.view.Gravity;
import android.view.View;
import android.widget.GridView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Typeface;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends Activity {
    private GridView grid;
    private final ArrayList<ResolveInfo> apps = new ArrayList<>();
    private AppsAdapter adapter;

    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        getWindow().getDecorView().setBackgroundColor(Color.rgb(20, 28, 42));
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(10, 12, 10, 10);

        TextView clock = new TextView(this);
        clock.setText("ANDROMAX LITE");
        clock.setTextColor(Color.WHITE);
        clock.setTextSize(20);
        clock.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        clock.setGravity(Gravity.CENTER);
        root.addView(clock, new LinearLayout.LayoutParams(-1, 48));

        grid = new GridView(this);
        grid.setNumColumns(3);
        grid.setVerticalSpacing(8);
        grid.setHorizontalSpacing(8);
        grid.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
        grid.setSelector(android.R.color.transparent);
        adapter = new AppsAdapter();
        grid.setAdapter(adapter);
        root.addView(grid, new LinearLayout.LayoutParams(-1, 0, 1));

        TextView footer = new TextView(this);
        footer.setText("ARAH: PILIH   OK: BUKA   MENU: MUAT ULANG");
        footer.setTextColor(Color.LTGRAY);
        footer.setTextSize(11);
        footer.setGravity(Gravity.CENTER);
        root.addView(footer, new LinearLayout.LayoutParams(-1, 36));
        setContentView(root);
        loadApps();
        grid.setSelection(0);
    }

    private void loadApps() {
        apps.clear();
        Intent query = new Intent(Intent.ACTION_MAIN, null);
        query.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> found = getPackageManager().queryIntentActivities(query, 0);
        Collections.sort(found, new Comparator<ResolveInfo>() {
            public int compare(ResolveInfo a, ResolveInfo b) {
                return a.loadLabel(getPackageManager()).toString().compareToIgnoreCase(
                    b.loadLabel(getPackageManager()).toString());
            }
        });
        apps.addAll(found);
        if (adapter != null) adapter.notifyDataSetChanged();
    }

    @Override public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) { loadApps(); return true; }
        if (keyCode >= KeyEvent.KEYCODE_1 && keyCode <= KeyEvent.KEYCODE_9) {
            int index = keyCode - KeyEvent.KEYCODE_1;
            if (index < apps.size()) launch(index);
            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
            launch(grid.getSelectedItemPosition()); return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void launch(int position) {
        if (position < 0 || position >= apps.size()) return;
        ResolveInfo info = apps.get(position);
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        i.setClassName(info.activityInfo.packageName, info.activityInfo.name);
        try { startActivity(i); } catch (Exception ignored) { }
    }

    private class AppsAdapter extends BaseAdapter {
        public int getCount() { return apps.size(); }
        public Object getItem(int p) { return apps.get(p); }
        public long getItemId(int p) { return p; }
        public View getView(int p, View old, android.view.ViewGroup parent) {
            LinearLayout cell = new LinearLayout(MainActivity.this);
            cell.setOrientation(LinearLayout.VERTICAL);
            cell.setGravity(Gravity.CENTER);
            cell.setPadding(3, 8, 3, 8);
            cell.setBackgroundColor(Color.rgb(37, 51, 72));
            TextView icon = new TextView(MainActivity.this);
            icon.setGravity(Gravity.CENTER);
            icon.setText(apps.get(p).loadIcon(getPackageManager()) == null ? "●" : "");
            icon.setCompoundDrawablesWithIntrinsicBounds(null, apps.get(p).loadIcon(getPackageManager()), null, null);
            icon.setCompoundDrawablePadding(3);
            cell.addView(icon, new LinearLayout.LayoutParams(-1, 54));
            TextView label = new TextView(MainActivity.this);
            label.setText(apps.get(p).loadLabel(getPackageManager()));
            label.setTextColor(Color.WHITE);
            label.setTextSize(12);
            label.setGravity(Gravity.CENTER);
            label.setMaxLines(2);
            cell.addView(label, new LinearLayout.LayoutParams(-1, 38));
            return cell;
        }
    }
}
