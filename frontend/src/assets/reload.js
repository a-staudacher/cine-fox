function reload_js(src)
{
  var head= document.getElementsByTagName('head')[0];
  var script= document.createElement('script');
  script.src= 'scripts.js';
  head.appendChild(script);
}
