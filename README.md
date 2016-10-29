## ColorfulTextView 一个支持不同字体大小，不同字体颜色，不同点击事件的TextView
![效果][./p.png]

- xml布局：

```
<com.bestmafen.colorfultextview.ColorfulTextView
        android:id="@+id/tv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
```

- java代码：

```
ColorfulTextView tv = (ColorfulTextView) findViewById(R.id.tv);
        tv.appendText(new Text("BLUE", Color.BLUE, 16), new OnTextClickListener() {

            @Override
            public void onTextClick(ColorfulTextView colorfulTextView, int position, String s) {
                Toast.makeText(MainActivity.this, position + s, Toast.LENGTH_SHORT).show();
            }
        });
        tv.appendText(new Text(" RED", Color.RED, 24), new OnTextClickListener() {

            @Override
            public void onTextClick(ColorfulTextView colorfulTextView, int position, String s) {
                Toast.makeText(MainActivity.this, position + s, Toast.LENGTH_SHORT).show();
            }
        });
        tv.appendText(new Text(" GREEN", Color.GREEN, 32), new OnTextClickListener() {

            @Override
            public void onTextClick(ColorfulTextView colorfulTextView, int position, String s) {
                Toast.makeText(MainActivity.this, position + s, Toast.LENGTH_SHORT).show();
            }
        });
```
---
#### ==联系作者：740178870==
