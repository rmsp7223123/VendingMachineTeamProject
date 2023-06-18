# teamprojectadsfsdf
 
자판기에서 음료수를 뽑았을 때 메인 페이지에서 뽑은 음료 이미지가 3초동안 나오고 (자판기처럼)
ResultActivity 영수증 출력하면 영수증 기록 날리기
음료관리 버튼 내용+기능 변경하기
돈을 넣지않았을 때 + 커피의 재고가 떨어졌을 때 이미지 버튼의 불빛이 들어오지 않게 수정



ImageView drink_imgv1 = findViewById(R.id.drink_imgv1);
        drink_imgv1.setImageResource(CommonVal.imgArr[0]);

public static int[] imgArr = { R.drawable.dirnk1 , R.drawable.drink2 };



 new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        } , 1000 * 3);
