// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require layout
//= require wf-utils/utils-ci.js
//= require wf-conversation.js
//= require wf-utils/classy
//= require utils/_tableSorting.js
//= require utils/report/_printAction.js

//= require layout
//= require wf-utils/jquery-form
//= require wf-utils/classy
//= require_tree /utils/jquery/
//= require_self
//= require wf-utils/upload
//= require common
//= require related/related
//= require wf-utils/message-dialog-box/messageDialogManipulation.js

if (typeof jQuery !== 'undefined') {
    (function($) {
        $(document).ajaxStart(function() {
            $('#spinner').fadeIn();
        }).ajaxStop(function() {
            $('#spinner').fadeOut();
        });
    })(jQuery);
}

function msg() {

}