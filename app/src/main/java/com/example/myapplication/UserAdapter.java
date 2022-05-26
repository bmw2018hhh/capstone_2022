package org.techtown.logindb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    //사용자 ID
    String id = "";
    //DB
    DBHelper dbHelper;
    //다이얼로그창
    AlertDialog.Builder builder;
    //사용자 정보 담을 리스트
    ArrayList<UserVo> items = new ArrayList<UserVo>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.user_item, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {
        UserVo item = items.get(position);
        viewHolder.setItem(item);

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = v.getContext();

                //db객체 생성
                dbHelper = new DBHelper(context.getApplicationContext(), "USER_INFO.db", null, 1);

                //선택한 사용자 id 담기
                id = items.get(position).getId();

                //다이얼로그박스 호출
                builder = new AlertDialog.Builder(context);
                builder.setTitle("삭제");
                builder.setMessage("[" + id + "]해당 항목을 삭제하시겠습니까?");
                builder.setPositiveButton("예",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                deleteItem(position);
                                notifyDataSetChanged();
                                dbHelper.delete(id);
                            }
                        });
                builder.setNegativeButton("아니오",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                builder.show();
            }
        });
    }

    /**
    * 아이템 갯수 가져오기
    * @return
    */
    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
    * 아이템 등록
    * @param alarmVo
    */
    public void addItem(UserVo alarmVo) {
        items.add(alarmVo);
    }

    public void deleteItem(int position) {
        items.remove(position);
    }

    /**
    * 아이템 전체 삭제
    */
    public void removeAllItem() {
        items.clear();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //초기화
        TextView tId;
        TextView tName;
        TextView tAge;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tId = itemView.findViewById(R.id.tId);
            tName = itemView.findViewById(R.id.tName);
            tAge = itemView.findViewById(R.id.tAge);
            cardView = itemView.findViewById(R.id.cardView);
        }

        public void setItem(UserVo vo) {

            //텍스트에 데이터 담기
            tId.setText(vo.getName());
            tName.setText(vo.getName());
            tAge.setText(vo.getName());
        }
    }
}
