/*
 Init scroll panel for tabs
*/
(function($) {

var $floorpanel = false; //Floor panel element
var panel_position = "left";
var panel_margin_container = 0; //Margin with container 10px
var container_class = ".ves-container > .container";
var panel_hidden_class = "hidden-xs hidden-sm";
var bottomElement = "#ves-footer";
var stop_bottom_offset = 400; //Height of footer block (400px)

var $window = $(window);
var $body = $(document.body);

//Function Strip Html Content
function stripHtml(html)
{
  var tmp = document.createElement("DIV");
  tmp.innerHTML = html;
  return tmp.textContent || tmp.innerText || "";
}

//Function Get Container Element Offset Left and Right
function getContainerMarginLeftRight( fixed_panel_width ) {

  var container_margin_left = (( $(window).width() - parseFloat( $(container_class).first().outerWidth(true) )  ) / 2) - parseFloat( panel_margin_container ) - parseFloat(fixed_panel_width);
  var container_margin_right = (( $(window).width() - parseFloat( $(container_class).first().outerWidth(true))  ) / 2) - parseFloat( panel_margin_container ) - parseFloat(fixed_panel_width);;

  var isOpera = !!window.opera || navigator.userAgent.indexOf(' OPR/') >= 0;
  var isSafari = Object.prototype.toString.call(window.HTMLElement).indexOf('Constructor') > 0;
  // At least Safari 3+: "[object HTMLElementConstructor]"
  var isChrome = !!window.chrome && !isOpera;      

  if(isChrome || isSafari || isOpera) {
    var container_margin = ($(".ves-container").first().width()  - $(container_class).first().width()) / 2;
    container_margin_left = container_margin - parseFloat( panel_margin_container ) - parseFloat(fixed_panel_width);
    container_margin_right = container_margin - parseFloat( panel_margin_container ) - parseFloat(fixed_panel_width);
  }
  return [container_margin_left, container_margin_right];
}

$(window).ready( function(){
    
      if($(".floor-fixed-panel-play").length > 0) {
              var $first_tab_position = $(".floor-fixed-panel-play").first().offset();
              var panel_margin_sidebar = [];

              $body.scrollspy('refresh')
              /*Init floor panel element*/
              $floorpanel = $('<div id="j-floor-fixed-panel" class="floor-fixed-panel '+panel_hidden_class+'"><ul class="nav floor-nav-list"></ul></div>');

              $(".floor-fixed-panel-play").each( function(){
                  var tab_id = $(this).data("index");
                  var floor_tab_id = $(this).attr("id");
                  var tab_title = $(this).data("title");
                  var tab_icon = $(this).data("icon");

                  if(tab_id !="" && typeof(tab_id) != "undefined") {

                      tab_icon = (typeof(tab_icon) != "undefined")?tab_icon:"";
                      tab_title = (typeof(tab_title) != "undefined")?tab_title:"";
                      tab_title = stripHtml(tab_title);

                      var $panelitem = $('<li class="nav-'+tab_id+'"><a class="floor-skin-'+tab_id+'" href="#'+floor_tab_id+'" title="'+tab_title+'"><i class="'+tab_icon+'"></i><span>'+tab_title+'</span></a></li>');
                      $(".floor-nav-list", $floorpanel ).append( $panelitem );  
                  }
                  
              });

              var $floorpanel_wrapper = $('<div id="j-floor-fixed-panel-sidebar"></div>');
              $floorpanel_wrapper.append( $floorpanel );

              $('body').append( $floorpanel_wrapper );

              $floorpanel.css({'position': 'fixed', 'top': $first_tab_position.top});
              //$floorpanel.css({'visibility': 'visible', 'position': 'fixed'});

              var fixed_pane_width = $("#j-floor-fixed-panel").width();
              //Fix position left or right for panel
              panel_margin_sidebar = getContainerMarginLeftRight( fixed_pane_width );

              if(panel_position == "left" ) {
                  $floorpanel.css( 'left', parseFloat(panel_margin_sidebar[0]) );
              } else if(panel_position == "right" ) {
                  $floorpanel.css( 'right', parseFloat(panel_margin_sidebar[1]) );
              }

              //Reset panel margin when resize window
              $(window).resize(function() {
                  panel_margin_sidebar = getContainerMarginLeftRight( fixed_pane_width );

                  if(panel_position == "left" ) {
                      $floorpanel.css( 'left', parseFloat(panel_margin_sidebar[0]) );
                  } else if(panel_position == "right" ) {
                      $floorpanel.css( 'right', parseFloat(panel_margin_sidebar[1]) );
                  }
              });
              /*End Init floor panel element*/

              $floorpanel.affix({
                    offset: {
                      top: function () {
                        return (this.top = $first_tab_position.top )
                      }, 
                      bottom: function () {
                        var stopOn = $( document ).height()-( $( bottomElement ).offset().top)+($floorpanel.outerHeight( true ) - $floorpanel.height()) + stop_bottom_offset;
                        return (this.bottom = stopOn )
                      }
                    }
              }).on('affixed-top.bs.affix', function(){ $("#j-floor-fixed-panel").css('top', $first_tab_position.top  ); });

              $('#j-floor-fixed-panel-sidebar').ddscrollSpy({ // initialize 2nd demo
                  highlightclass: 'active',
                  scrollduration: 300 // <-- no comma after last option!
              })

              setTimeout(function () {
                // Check the position of the nav box ASAP
                 $floorpanel.affix('checkPosition');
                 $('#j-floor-fixed-panel-sidebar').trigger('updatespy')

              }, 10);
              setTimeout(function () {
                  // Check it again after a while (required for IE)
                  $floorpanel.affix('checkPosition');
                  $('#j-floor-fixed-panel-sidebar').trigger('updatespy')

              }, 100);
      }
  });
})(jQuery);