$('select').on('change', function() {
    alert( this.value ); // or $(this).val()
});
function getval(sel)
{
    if(sel.value=="triangle")
        document.getElementsByName("triangle").style.display = "none";
    //alert(sel.value);
}