//all선택버튼 클릭시
$(document).ready(function (){

    //체크박스 올 선택
    $("#allCheck").on('click',function (){
        var chk = $(".allCheck").prop("checked");
        if (chk){
            $(chBox).prop("checked", true);
        }else{
            $(chBox).prop("checked", false);
        }

    });

    //체크박스 개별선택
    function chBox() {
        if ($("#allCheck").is(':checked')) {
            $("input[type=checkbox]").prop("checked", true);
        } else {
            $("input[type=checkbox]").prop("checked", false);
        }
    }

    /********************/
    //선택 삭제버튼 눌렀을 시
    /********************/
    $(".selectdelete_btn").on('click', function (){

  /*      if(checkArr ==  ""){
            alert("삭제할 내용이 없습니다.")*/
     //   }else {
            var confirm1_val = confirm("정말 삭제하시겠습니까?");
            if(confirm1_val){
                // 어레이 초기화 생성
                var checkArr = new Array();
            }
      //  }

        // 체크박스 체크된곳까지 돌리는 문
        $("input[class='chBox']:checked").each(function (){
            checkArr.push($(this).attr("data_no")); //속성추가
        });
        /****************/
        /* 삭제처리 아작스 */
        /****************/
        $.ajax({
            url : "/deleteData",
            type : "post",
            data : {chBox : checkArr}, //chBox를 checkArr 까지 넣어서 보내기
            success : function (result){
                if(result==1){
                    alert("성공적으로 지워졌습니다.");
                    window.location.href = 'http://127.0.0.1:81/pclist';
                }else if(result != 1){
                    alert("삭제 내용이 없습니다.");
                }

            },
            error: function(xhr, status, err) {
                alert("삭제할 내용이 없었습니다");
                console.error(err);
            }
        });
    });
    /****************/
    /* 단독 삭제버튼 */
    /****************/
    $(".delete_btn").on('click', function (){
        var confirm_val = confirm("정말 삭제하시겠습니까?");

        if(confirm_val){
            var checkArr = new Array();
            //속성추가
            checkArr.push($(this).attr("data_no"));

            $.ajax({
                url : "/deleteData",
                type : "post",
                data : {chBox:checkArr},
                success : function (result){
                    if(result == 1){
                        alert("성공적으로 지워졌습니다.")
                        window.location.href = 'http://127.0.0.1:81/pclist';
                    }else {
                        alert("삭제 실패");
                    }
                }
            });
        }
    });

/*
$("#allCheck").click(function(){
 var chk = $("#allCheck").prop("checked");
 if(chk) {
  $(".chBox").prop("checked", true);
 } else {
  $(".chBox").prop("checked", false);
 }
});

 $(".chBox").click(function(){
  $("#allCheck").prop("checked", false);
 });

* */
});
