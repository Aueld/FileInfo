package com.example.fileinfodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 폴더 생성
        File f = new File(getFilesDir(), "abc");
        if(!f.exists())
            f.mkdir();

    }

    private File file;
    // Exam
    public void save(View view) throws IOException{
        EditText textEdit = findViewById(R.id.text);
        String text = textEdit.getText().toString();
        EditText filenameEdit = findViewById(R.id.filename);
        String filename = filenameEdit.getText().toString();
        //getFilesDir()
        // = data / ... / files
        File f1 = new File(getFilesDir(), "abc");
        File f2 = new File(f1, filename);
        // 폴더 안에 파일 생성
        FileWriter fw = new FileWriter(f2);
        fw.write(text);
        fw.close();

//        FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
//        fos.write(text.getBytes());
//        fos.close();
//
//        FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
//        //FileOutputStream fos = openFileOutput(filename, Context.MODE_APPEND);
////바이트로바꿔서저장
//        fos.write(text.getBytes());
//        fos.close();


//        EditText textEdit = findViewById(R.id.text);
//        String text = textEdit.getText().toString();
//        EditText fileEdit = findViewById(R.id.filename);
//        String filename = fileEdit.getText().toString(     );
////캐시에임시파일생성
//        file = File.createTempFile(filename,null,getCacheDir());
//        FileWriter fw = new FileWriter(file);
//        fw.write(text);
//        fw.close();
    }
    public void load(View view) throws IOException {
        EditText filenameEdit = findViewById(R.id.filename);

        String filename = filenameEdit.getText().toString();
        FileInputStream fis = openFileInput(filename);

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String str = br.readLine();
        EditText textEdit = findViewById(R.id.text);
        textEdit.setText(str);
        br.close();

        String Path = getFilesDir().getAbsolutePath() + "/abc/" + filename;
//
//        File f1 = new File(getFilesDir(), "abc");
//        File f2 = new File(f1, filename);
        // 폴더 안에 파일 생성
//        FileReader fr = new FileReader(f2);

        FileInputStream fr = new FileInputStream(Path);
        BufferedReader br2 = new BufferedReader(new InputStreamReader(fr));

        textEdit.setText(br2.readLine());
        fr.close();



//        EditText textEdit = findViewById(R.id.text);
//
//        BufferedReader br = new BufferedReader(new FileReader(file));
//        textEdit.setText(br.readLine());
//
//        br.close();

    }
//    // xml 안쓰는 법
//    Vieww v;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    // xml 안쓰는 법
//        v = new Vieww(this);
//        setContentView(v);
//
//        display(getFilesDir());//앱전용폴더
//        display(getExternalFilesDir(null));//공유폴더
//        display(getCacheDir());//앱전용캐시
//        display(new File("etc/hosts"));
//
//        // 파일 생성
//        File f = new File(getFilesDir(), "abc.txt");
//
//
//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
//            bw.write("123456");
//            bw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        display(f);
//
//
//        try {
//            // f.절대경로 = 경로 안에 경로라서 에라
//            FileOutputStream is = openFileOutput("abc.txt", MODE_APPEND);
//
//            OutputStreamWriter writer = new OutputStreamWriter(is);
//            writer.write("lkjdfslkjdfslkj");
//            writer.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void display(File file) {
//        //TextView info = findViewById(R.id.info);
//        // xml 안쓰는 법
//        TextView info = v.getTextView();
//
//        info.append("경로 : " + file.getAbsolutePath() + "\n");
//        info.append("읽기 : " + file.canRead() + "\n");
//        info.append("쓰기 : " + file.canWrite() + "\n");
//        info.append("날짜 : " + new Date(file.lastModified()) + "\n\n");
//
//    }
}