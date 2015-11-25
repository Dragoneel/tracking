(function($) {
    function addJSProduct(currentProduct) {
        try {
            $('.thumbs_list_' + currentProduct).serialScroll({
                items: 'li:visible',
                prev: '.view_scroll_left_' + currentProduct,
                next: '.view_scroll_right_' + currentProduct,
                axis: 'y',
                offset: 0,
                start: 0,
                stop: true,
                duration: 700,
                step: 1,
                lazy: true,
                lock: false,
                force: false,
                cycle: false
            });
            $('.thumbs_list_' + currentProduct).trigger('goto', 1);// SerialScroll Bug on goto 0 ?
            $('.thumbs_list_' + currentProduct).trigger('goto', 0);
        }
        catch(err) { console.log("\n" + err); }
    }
    
    $(window).ready( function(){
         /* automatic keep header always displaying on top */
        if( $("body").hasClass("layout-boxed-md") || $("body").hasClass("layout-boxed-lg") || mobilecheck()){

        }else if( $("body").hasClass("keep-header") ){
            var mb = parseInt($("#header-main").css("margin-bottom"));
            var hideheight =  $("#topbar").height()+mb+mb; 
            var hh =  $("#header").height() + mb;  
            var updateTopbar = function(){
                 var pos = $(window).scrollTop();
                 if( pos >= hideheight ){
                    //$("#page").css( "padding-top", hh );
                    $("#header").addClass('hide-bar');
                    $("#header").addClass( "navbar navbar-fixed-top" );
                  
                }else {
                    $("#header").removeClass('hide-bar');
                } 
            }
            $(window).scroll(function() {
               updateTopbar();
            });
        }
        /*lazy load image*/
        if($("img.lazy").length > 0) {
            $("img.lazy").lazyload({ event: "scroll whenever-i-want", threshold : 200, effect: "show"});/*effect: show | fadein*/
            $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
                $(document).trigger('whenever-i-want');
            });
            $(".carousel").on('slid.bs.carousel', function (e) {
                var $active = $(e.target).find('.carousel-inner > .item.active').first();
                if($active.find("img.lazy").length > 0) {
                    $active.find("img.lazy").lazyload({ event: "whenever-i-want", threshold : 200, effect: "show"});/*effect: show | fadein*/
                    $active.find("img.lazy").trigger('whenever-i-want');
                }
            });
        }

        //hover image
        if($(".thumb_more_info").length > 0) {
            
            $(".thumb_more_info").each(function() {
                addJSProduct($(this).attr("data-rel"));
            });

            $(".thumb_more_info").each(function() {
                var ves_preview = this;
                var speed = 800;
                var effect = "easeInOutQuad";
                $(ves_preview).find(".ves-hover-image").each(function() {
                    $(this).mouseover(function() {
                        var big_image = $(this).attr("data-rel");
                        imgElement = $(ves_preview).parent().find("a.product-image img").first();
                        if (imgElement.length) {
                            $(imgElement).attr("src", big_image); 
                            $(imgElement).attr("data-rel", big_image);
                        }
                    });
                });
            });
        }
        
    });

})(jQuery);
