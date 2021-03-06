package com.example.newXiaoMi.ui.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newXiaoMi.model.DoneThing;
import com.example.newXiaoMi.model.TodoThing;
import com.example.xiaomi.R;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/*adapter是数据与ui之间的桥梁，它把后台数据与前端ui连接到一起，是一个展示数据的载体。
 *使用示例： https://cloud.tencent.com/developer/ask/200116*/

public class DoneAdapter extends RecyclerView.Adapter<DoneAdapter.ViewHolder> {
    Context context;
    MutableLiveData<List<TodoThing>> todoLive;
    MutableLiveData<List<DoneThing>> donLive;
    List<DoneThing> doneThings;
    TextView deldteY;
    TextView deldteN;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.done_item,parent,false);
       ViewHolder viewHolder = new ViewHolder(view);
       return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.textView.setText(doneThings.get(position).getContent());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoThing todoThing = new TodoThing();
               if(!((position+1)>doneThings.size())){

                   todoThing.setContent(doneThings.get(position).getContent());
                   todoThing.setBookName(doneThings.get(position).gettBookName());
                   todoThing.save();
                   todoLive.postValue(DataSupport.where("bookName=?",doneThings.get(position).gettBookName()).find(TodoThing.class));
                   DataSupport.delete(DoneThing.class,doneThings.get(position).getId());
                   doneThings.remove(position);
                   notifyDataSetChanged();
               }
            }
        });
        //设置长按删除
        holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                final  AlertDialog dialog = builder.create();
                View dialogview = View.inflate(context,R.layout.delete_todo,null);
                dialog.setView(dialogview);
                dialog.show();
                //点击确定  删除
                deldteY = dialogview.findViewById(R.id.sureDelete);
                deldteY.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DataSupport.delete(DoneThing.class,doneThings.get(position).getId());
                        doneThings.remove(position);
                        notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                deldteN = dialogview.findViewById(R.id.cancleDelete);
                deldteN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        if(doneThings==null){
            doneThings =new ArrayList<>();
        }
        return doneThings.size();
    }

    public DoneAdapter(Context context, MutableLiveData<List<TodoThing>> todoLive, MutableLiveData<List<DoneThing>> donLive, List<DoneThing> doneThings) {
        this.context = context;
        this.todoLive = todoLive;
        this.donLive = donLive;
        this.doneThings = doneThings;
    }

    public void setDoneThings(List<DoneThing> doneThings) {
      this.doneThings = doneThings;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //layout/done_itme
            imageView =itemView.findViewById(R.id.checkDone);
            textView = itemView.findViewById(R.id.doneText);
        }
    }
}
