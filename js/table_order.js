/**
 * Created by {Nguenchik} on 25.10.2017.
 */
$(document).ready(function () {
    $('.make-or-edit').hide()
    $('.table_sure').on('click', function () {
        $('.table_hide').hide(),
        $('.make-or-edit').show();
    });
    $('.edit-table').on('click',function () {
        document.location.href = "index1.html";
    });
    
});