# teamprojectadsfsdf
 
자판기에서 음료수를 뽑았을 때 메인 페이지에서 뽑은 음료 이미지가 3초동안 나오고 (자판기처럼)
다시 사라짐 잔돈을 반환시 (배경)영수증 == > 글자, 가격, 개수
몇 개 남음 처리 안보이게 하고 0이 될 때 토스트로 구매불가 문구 추가
음료관리 이미지 8장 변경



ImageView drink_imgv1 = findViewById(R.id.drink_imgv1);
        drink_imgv1.setImageResource(CommonVal.imgArr[0]);

public static int[] imgArr = { R.drawable.dirnk1 , R.drawable.drink2 };



 new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        } , 1000 * 3);
