### Example 1: Which protocols does a virtual machine support?

```java
import java.net.*;

public class ProtocolTester {
    public static void main(String[] args) {
        // Testing various protocols

        // Hypertext Transfer Protocol (HTTP)
        testProtocol("http://www.adc.org");

        // Secure Hypertext Transfer Protocol (HTTPS)
        testProtocol("https://www.amazon.com/exec/obidos/order2/");

        // File Transfer Protocol (FTP)
        testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq/");

        // Simple Mail Transfer Protocol (MAILTO)
        testProtocol("mailto:elharo@ibiblio.org");

        // Telnet Protocol
        testProtocol("telnet://dibner.poly.edu/");
    }

    private static void testProtocol(String url) {
        try {
            // Try to create a URL object; throws MalformedURLException if protocol is not supported
            URL u = new URL(url);
            System.out.println(u.getProtocol() + " is supported");
        } catch (MalformedURLException ex) {
            // Extracting the protocol from the URL string
            String protocol = url.substring(0, url.indexOf(':'));
            System.out.println(protocol + " is not supported");
        }
    }
}
```
#### Expected output:
```
http is supported
https is supported
ftp is supported
mailto is supported
telnet is not supported
```

---
### 2. Example 2: Download a web page
```java
import java.io.*;
import java.net.*;

public class SourceViewer {
    public static void main(String[] args) {
        try {
            // Open the URL for reading
            URL url = new URL("http://google.com");

            // Buffer the input to improve performance
            BufferedReader inData = new BufferedReader(new InputStreamReader(url.openStream()));

            /*The url.openStream() opens the connection and retrieves the web page's content as a byte stream.
            The InputStreamReader converts the byte stream into character data.
            The BufferedReader reads and stores multiple characters in memory for faster access.*/

            String line;
            while ((line = inData.readLine()) != null) {
                System.out.println(line);
            }

            // Close the BufferedReader
            inData.close();

        } catch (MalformedURLException ex) {
            System.err.println("The provided URL is not valid.");
        } catch (IOException ex) {
            System.err.println("Error reading from the URL: " + ex.getMessage());
        }
    }
}

```
#### Expected Output:

```
<!doctype html><html itemscope="" itemtype="http://schema.org/WebPage" lang="ne"><head><meta content="text/html; charset=UTF-8" http-equiv="Content-Type"><meta content="/images/branding/googleg/1x/googleg_standard_color_128dp.png" itemprop="image"><title>Google</title><script nonce="77M0wJegG8sUk8Q9PaMp8w">(function(){var _g={kEI:'YY-TZ4yNNvnD5OUP2Ka8uQ4',kEXPI:'0,3700287,662,435,316223,222438,2872,2891,43028,30022,6397,9708,239272,105524,45786,9779,156486,47082,30911,5240757,766,47,8834864,13,13,5,10,12,3,3,3,3,9,4,2,7,27977803,25228681,112218,5089,5797,15164,8182,21337,28092,9236,12430,6758,21349,2529,9139,4600,328,6225,10418,17572,5633,687,29855,1346,5323,8379,15635,3750,8840,5218,3494,33,9041,17667,15647,5923,10148,8633,41,13162,477,1,1720,5021,2848,1258,4452,3316,11533,844,5908,621,1528,758,1297,2559,5773,2632,2,1676,1462,910,1265,738,4378,3589,750,17,461,122,1908,965,3,2,3672,3060,4409,1943,1,5552,131,1729,2759,233,2226,803,37,2,419,152,1694,352,1243,844,268,107,286,646,394,215,499,1789,93,1136,25,584,32,246,217,1,319,511,1,80,11,130,1,34,667,1354,541,1153,9,17,537,926,2003,287,66,569,148,1,3,1072,60,595,372,116,563,1262,403,749,142,256,600,221,685,268,733,8,341,235,2091,260,354,305,353,373,6,108,17,3,697,791,1053,16,688,1073,410,2273,890,2,400,526,2,98,126,207,13,713,687,3,2,1,2,2,2,3,770,6,5,290,99,272,25,75,131,75,72,86,1,7,491,315,43,544,14,57,97,954,98,648,75,6,4,133,935,71,332,8,1,3,1070,153,313,212,21373293,92,4848,18,2010,48,527,1955,8,3327,546,12,532,6,151,1065,1201,8021157',kBL:'WNRz',kOPI:89978449};(function(){var a;((a=window.google)==null?0:a.stvsc)?google.kEI=_g.kEI:window.google=_g;}).call(this);})();(function(){google.sn='webhp';google.kHL='ne';})();(function(){
var g=this||self;function k(){return window.google&&window.google.kOPI||null};var l,m=[];function n(a){for(var b;a&&(!a.getAttribute||!(b=a.getAttribute("eid")));)a=a.parentNode;return b||l}function p(a){for(var b=null;a&&(!a.getAttribute||!(b=a.getAttribute("leid")));)a=a.parentNode;return b}function q(a){/^http:/i.test(a)&&window.location.protocol==="https:"&&(google.ml&&google.ml(Error("a"),!1,{src:a,glmm:1}),a="");return a}
function r(a,b,d,c,h){var e="";b.search("&ei=")===-1&&(e="&ei="+n(c),b.search("&lei=")===-1&&(c=p(c))&&(e+="&lei="+c));var f=b.search("&cshid=")===-1&&a!=="slh";c="&zx="+Date.now().toString();g._cshid&&f&&(c+="&cshid="+g._cshid);(d=d())&&(c+="&opi="+d);return"/"+(h||"gen_204")+"?atyp=i&ct="+String(a)+"&cad="+(b+e+c)};l=google.kEI;google.getEI=n;google.getLEI=p;google.ml=function(){return null};google.log=function(a,b,d,c,h,e){e=e===void 0?k:e;d||(d=r(a,b,e,c,h));if(d=q(d)){a=new Image;var f=m.length;m[f]=a;a.onerror=a.onload=a.onabort=function(){delete m[f]};a.src=d}};google.logUrl=function(a,b){b=b===void 0?k:b;return r("",a,b)};}).call(this);(function(){google.y={};google.sy=[];var d;(d=google).x||(d.x=function(a,b){if(a)var c=a.id;else{do c=Math.random();while(google.y[c])}google.y[c]=[a,b];return!1});var e;(e=google).sx||(e.sx=function(a){google.sy.push(a)});google.lm=[];var f;(f=google).plm||(f.plm=function(a){google.lm.push.apply(google.lm,a)});google.lq=[];var g;(g=google).load||(g.load=function(a,b,c){google.lq.push([[a],b,c])});var h;(h=google).loadAll||(h.loadAll=function(a,b){google.lq.push([a,b])});google.bx=!1;var k;(k=google).lx||(k.lx=function(){});var l=[],m;(m=google).fce||(m.fce=function(a,b,c,n){l.push([a,b,c,n])});google.qce=l;}).call(this);google.f={};(function(){
document.documentElement.addEventListener("submit",function(b){var a;if(a=b.target){var c=a.getAttribute("data-submitfalse");a=c==="1"||c==="q"&&!a.elements.q.value?!0:!1}else a=!1;a&&(b.preventDefault(),b.stopPropagation())},!0);document.documentElement.addEventListener("click",function(b){var a;a:{for(a=b.target;a&&a!==document.documentElement;a=a.parentElement)if(a.tagName==="A"){a=a.getAttribute("data-nohref")==="1";break a}a=!1}a&&b.preventDefault()},!0);}).call(this);</script><style>#gbar,#guser{font-size:13px;padding-top:1px !important;}#gbar{height:22px}#guser{padding-bottom:7px !important;text-align:right}.gbh,.gbd{border-top:1px solid #c9d7f1;font-size:1px}.gbh{height:0;position:absolute;top:24px;width:100%}@media all{.gb1{height:22px;margin-right:.5em;vertical-align:top}#gbar{float:left}}a.gb1,a.gb4{text-decoration:underline !important}a.gb1,a.gb4{color:#00c !important}.gbi .gb4{color:#dd8e27 !important}.gbf .gb4{color:#900 !important}
</style><style>body,td,a,p,.h{font-family:sans-serif}body{margin:0;overflow-y:scroll}#gog{padding:3px 8px 0}td{line-height:.8em}.gac_m td{line-height:17px}form{margin-bottom:20px}.h{color:#1967d2}em{font-weight:bold;font-style:normal}.lst{height:25px;width:496px}.gsfi,.lst{font:18px sans-serif}.gsfs{font:17px sans-serif}.ds{display:inline-box;display:inline-block;margin:3px 0 4px;margin-left:4px}input{font-family:inherit}body{background:#fff;color:#000}a{color:#681da8;text-decoration:none}a:hover,a:active{text-decoration:underline}.fl a{color:#1967d2}a:visited{color:#681da8}.sblc{padding-top:5px}.sblc a{display:block;margin:2px 0;margin-left:13px;font-size:11px}.lsbb{background:#f8f9fa;border:solid 1px;border-color:#dadce0 #70757a #70757a #dadce0;height:30px}.lsbb{display:block}#WqQANb a{display:inline-block;margin:0 12px}.lsb{background:url(/images/nav_logo229.png) 0 -261px repeat-x;color:#000;border:none;cursor:pointer;height:30px;margin:0;outline:0;font:15px sans-serif;vertical-align:top}.lsb:active{background:#dadce0}.lst:focus{outline:none}.Ucigb{width:458px}</style><script nonce="77M0wJegG8sUk8Q9PaMp8w">(function(){window.google.erd={jsr:1,bv:2157,de:true,dpf:'NpY_mruy0zzJdlb_X263qOwChaSnnbYWuVZ0B2do2o8'};
var g=this||self;var k,l=(k=g.mei)!=null?k:1,m,p=(m=g.diel)!=null?m:0,q,r=(q=g.sdo)!=null?q:!0,t=0,u,w=google.erd,x=w.jsr;google.ml=function(a,b,d,n,e){e=e===void 0?2:e;b&&(u=a&&a.message);d===void 0&&(d={});d.cad="ple_"+google.ple+".aple_"+google.aple;if(google.dl)return google.dl(a,e,d,!0),null;b=d;if(x<0){window.console&&console.error(a,b);if(x===-2)throw a;b=!1}else b=!a||!a.message||a.message==="Error loading script"||t>=l&&!n?!1:!0;if(!b)return null;t++;d=d||{};b=encodeURIComponent;var c="/gen_204?atyp=i&ei="+b(google.kEI);google.kEXPI&&(c+="&jexpid="+b(google.kEXPI));c+="&srcpg="+b(google.sn)+"&jsr="+b(w.jsr)+
"&bver="+b(w.bv);w.dpf&&(c+="&dpf="+b(w.dpf));var f=a.lineNumber;f!==void 0&&(c+="&line="+f);var h=a.fileName;h&&(h.indexOf("-extension:/")>0&&(e=3),c+="&script="+b(h),f&&h===window.location.href&&(f=document.documentElement.outerHTML.split("\n")[f],c+="&cad="+b(f?f.substring(0,300):"No script found.")));google.ple&&google.ple===1&&(e=2);c+="&jsel="+e;for(var v in d)c+="&",c+=b(v),c+="=",c+=b(d[v]);c=c+"&emsg="+b(a.name+": "+a.message);c=c+"&jsst="+b(a.stack||"N/A");c.length>=12288&&(c=c.substr(0,12288));a=c;n||google.log(0,"",a);return a};window.onerror=function(a,b,d,n,e){u!==a&&(a=e instanceof Error?e:Error(a),d===void 0||"lineNumber"in a||(a.lineNumber=d),b===void 0||"fileName"in a||(a.fileName=b),google.ml(a,!1,void 0,!1,a.name==="SyntaxError"||a.message.substring(0,11)==="SyntaxError"||a.message.indexOf("Script error")!==-1?3:p));u=null;r&&t>=l&&(window.onerror=null)};})();</script></head><body bgcolor="#fff"><script nonce="77M0wJegG8sUk8Q9PaMp8w">(function(){var src='/images/nav_logo229.png';var iesg=false;document.body.onload = function(){window.n && window.n();if (document.images){new Image().src=src;}
if (!iesg){document.f&&document.f.q.focus();document.gbqf&&document.gbqf.q.focus();}
}
})();</script><div id="mngb"><div id=gbar><nobr><b class=gb1>&#2326;&#2379;&#2332;</b> <a class=gb1 href="https://www.google.com/imghp?hl=ne&tab=wi">&#2347;&#2379;&#2335;&#2379;</a> <a class=gb1 href="http://maps.google.com.np/maps?hl=ne&tab=wl">&#2344;&#2325;&#2381;&#2360;&#2366;</a> <a class=gb1 href="https://play.google.com/?hl=ne&tab=w8">Play</a> <a class=gb1 href="https://news.google.com/?tab=wn">&#2360;&#2350;&#2366;&#2330;&#2366;&#2352;</a> <a class=gb1 href="https://mail.google.com/mail/?tab=wm">Gmail</a> <a class=gb1 href="https://drive.google.com/?tab=wo">Drive</a> <a class=gb1 href="https://calendar.google.com/calendar?tab=wc">&#2346;&#2366;&#2340;&#2381;&#2352;&#2379;</a> <a class=gb1 style="text-decoration:none" href="https://www.google.com.np/intl/en/about/products?tab=wh"><u>&#2341;&#2346;</u> &raquo;</a></nobr></div><div id=guser width=100%><nobr><span id=gbn class=gbi></span><span id=gbf class=gbf></span><span id=gbe></span><a href="http://www.google.com.np/history/optout?hl=ne" class=gb4>&#2357;&#2375;&#2348; &#2311;&#2340;&#2367;&#2361;&#2366;&#2360;</a> | <a  href="/preferences?hl=ne" class=gb4>&#2346;&#2381;&#2352;&#2366;&#2341;&#2350;&#2367;&#2325;&#2340;&#2366;&#2361;&#2352;&#2370;</a> | <a target=_top id=gb_70 href="https://accounts.google.com/ServiceLogin?hl=ne&passive=true&continue=http://www.google.com/&ec=GAZAAQ" class=gb4>&#2360;&#2366;&#2311;&#2344; &#2311;&#2344;</a></nobr></div><div class=gbh style=left:0></div><div class=gbh style=right:0></div></div><center><br clear="all" id="lgpd"><div id="XjhHGf"><img alt="Google" height="92" src="/images/branding/googlelogo/1x/googlelogo_white_background_color_272x92dp.png" style="padding:28px 0 14px" width="272" id="hplogo"><br><br></div><form action="/search" name="f"><table cellpadding="0" cellspacing="0"><tr valign="top"><td width="25%">&nbsp;</td><td align="center" nowrap=""><input name="ie" value="ISO-8859-1" type="hidden"><input value="ne" name="hl" type="hidden"><input name="source" type="hidden" value="hp"><input name="biw" type="hidden"><input name="bih" type="hidden"><div class="ds" style="height:32px;margin:4px 0"><div style="position:relative;zoom:1"><input class="lst Ucigb" style="margin:0;padding:5px 8px 0 6px;vertical-align:top;color:#000;padding-right:38px" autocomplete="off" value="" title="Google &#2326;&#2379;&#2332;&#2368;" maxlength="2048" name="q" size="57"><img src="/textinputassistant/tia.png" style="position:absolute;cursor:pointer;right:5px;top:4px;z-index:300" data-script-url="/textinputassistant/13/ne_tia.js" id="tsuid_YY-TZ4yNNvnD5OUP2Ka8uQ4_1" alt="" height="23" width="27"><script nonce="77M0wJegG8sUk8Q9PaMp8w">(function(){var id='tsuid_YY-TZ4yNNvnD5OUP2Ka8uQ4_1';document.getElementById(id).onclick = function(){var s = document.createElement('script');s.src = this.getAttribute('data-script-url');document.body.appendChild(s);};})();</script></div></div><br style="line-height:0"><span class="ds"><span class="lsbb"><input class="lsb" value="Google &#2326;&#2379;&#2332;&#2368;" name="btnG" type="submit"></span></span><span class="ds"><span class="lsbb"><input class="lsb" id="tsuid_YY-TZ4yNNvnD5OUP2Ka8uQ4_2" value="&#2350; &#2349;&#2366;&#2327;&#2381;&#2351;&#2350;&#2366;&#2344;&#2368; &#2309;&#2344;&#2369;&#2349;&#2370;&#2340;&#2367; &#2327;&#2352;&#2367;&#2352;&#2361;&#2375;&#2331;&#2369;" name="btnI" type="submit"><script nonce="77M0wJegG8sUk8Q9PaMp8w">(function(){var id='tsuid_YY-TZ4yNNvnD5OUP2Ka8uQ4_2';document.getElementById(id).onclick = function(){if (this.form.q.value){this.checked = 1;if (this.form.iflsig)this.form.iflsig.disabled = false;}
else top.location='/doodles/';};})();</script><input value="ACkRmUkAAAAAZ5OdcYKwUUgIVMxZpPFqt4F8ZorKQmmF" name="iflsig" type="hidden"></span></span></td><td class="fl sblc" align="left" nowrap="" width="25%"><a href="/advanced_search?hl=ne&amp;authuser=0">&#2313;&#2344;&#2381;&#2344;&#2340; &#2326;&#2379;&#2332; </a></td></tr></table><input id="gbv" name="gbv" type="hidden" value="1"><script nonce="77M0wJegG8sUk8Q9PaMp8w">(function(){var a,b="1";if(document&&document.getElementById)if(typeof XMLHttpRequest!="undefined")b="2";else if(typeof ActiveXObject!="undefined"){var c,d,e=["MSXML2.XMLHTTP.6.0","MSXML2.XMLHTTP.3.0","MSXML2.XMLHTTP","Microsoft.XMLHTTP"];for(c=0;d=e[c++];)try{new ActiveXObject(d),b="2"}catch(h){}}a=b;if(a=="2"&&location.search.indexOf("&gbv=2")==-1){var f=google.gbvu,g=document.getElementById("gbv");g&&(g.value=a);f&&window.setTimeout(function(){location.href=f},0)};}).call(this);</script></form><div style="font-size:83%;min-height:3.5em"><br><div id="gws-output-pages-elements-homepage_additional_languages__als"><style>#gws-output-pages-elements-homepage_additional_languages__als{font-size:small;margin-bottom:24px}#SIvCob{color:#474747;display:inline-block;line-height:28px;}#SIvCob a{padding:0 3px;}.H6sW5{display:inline-block;margin:0 2px;white-space:nowrap}.z4hgWe{display:inline-block;margin:0 2px}</style><div id="SIvCob">Google &#2351;&#2368; &#2349;&#2366;&#2359;&#2366;&#2350;&#2366; &#2313;&#2346;&#2354;&#2348;&#2381;&#2343; &#2331;:  <a href="http://www.google.com/setprefs?sig=0_Vsg5UjCI78GulE-Bk5QB6LlNl3E%3D&amp;hl=en&amp;source=homepage&amp;sa=X&amp;ved=0ahUKEwjMwd20tY6LAxX5IbkGHVgTL-cQ2ZgBCAY">English</a>  </div></div></div><span id="footer"><div style="font-size:10pt"><div style="margin:19px auto;text-align:center" id="WqQANb"><a href="/intl/ne/ads/"> &#2357;&#2367;&#2332;&#2381;&#2334;&#2366;&#2346;&#2344; </a><a href="/intl/ne/about.html">Google&#2325;&#2379; &#2348;&#2366;&#2352;&#2375;&#2350;&#2366; &#2360;&#2350;&#2381;&#2346;&#2370;&#2352;&#2381;&#2339;</a><a href="http://www.google.com/setprefdomain?prefdom=NP&amp;prev=http://www.google.com.np/&amp;sig=K_HAmJkwRGO7sdzK8TX0viTgqouvQ%3D">Google.com.np</a></div></div><p style="font-size:8pt;color:#70757a">&copy; 2025</p></span></center><script nonce="77M0wJegG8sUk8Q9PaMp8w">(function(){window.google.cdo={height:757,width:1440};(function(){var a=window.innerWidth,b=window.innerHeight;if(!a||!b){var c=window.document,d=c.compatMode=="CSS1Compat"?c.documentElement:c.body;a=d.clientWidth;b=d.clientHeight}if(a&&b&&(a!=google.cdo.width||b!=google.cdo.height)){var e=google,f=e.log,g="/client_204?&atyp=i&biw="+a+"&bih="+b+"&ei="+google.kEI,h="",k=window.google&&window.google.kOPI||null;k&&(h+="&opi="+k);f.call(e,"","",g+h)};}).call(this);})();</script>   <script nonce="77M0wJegG8sUk8Q9PaMp8w">(function(){google.xjs={basecomb:'/xjs/_/js/k\x3dxjs.hp.en.KVYh0rSJW0I.es5.O/ck\x3dxjs.hp.DWgEyZ2blW0.L.X.O/am\x3dBAAAAAAAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAgCAAAAAAAAAAAHALAGAAAQAECAAAAAAAAAAAAAAAAkAIAFAIEAAACI7wgABMAiAAC8/d\x3d1/ed\x3d1/dg\x3d0/ujg\x3d1/rs\x3dACT90oFN7pPOo6Ol4h6lOTptkEBnLtffTw',basecss:'/xjs/_/ss/k\x3dxjs.hp.DWgEyZ2blW0.L.X.O/am\x3dBAAAAAAAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACAAAAAAAAAAAAALAAAAAQAECAAAAAAAAAAAAAAAAkAIAFAIE/rs\x3dACT90oEwAzagw7Sva8gmJ3zwGJ39IOUjaQ',basejs:'/xjs/_/js/k\x3dxjs.hp.en.KVYh0rSJW0I.es5.O/am\x3dAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAgAAAAAAAAAAAAHAAAGAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACI7wgABMAiAAC8/dg\x3d0/rs\x3dACT90oHVznllMWtwEHsOPWFRI-tgMdPkhw',excm:[]};})();</script>        <script nonce="77M0wJegG8sUk8Q9PaMp8w">(function(){var u='/xjs/_/js/k\x3dxjs.hp.en.KVYh0rSJW0I.es5.O/am\x3dAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAgAAAAAAAAAAAAHAAAGAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACI7wgABMAiAAC8/d\x3d1/ed\x3d1/dg\x3d3/rs\x3dACT90oHVznllMWtwEHsOPWFRI-tgMdPkhw/m\x3dsb_he,d';var st=1;var amd=1000;var mmd=0;var pod=true;
var e=this||self;function f(){var a,b,d;if(b=a=(b=window.google)==null?void 0:(d=b.ia)==null?void 0:d.r.B2Jtyd)b=a.m,b=b===1||b===5;return b&&a.cbfd!=null&&a.cbvi!=null?a:void 0};function g(){var a=[u];if(!google.dp){for(var b=0;b<a.length;b++){var d=a[b],c=document.createElement("link");c.as="script";c.href=d;c.rel="preload";document.body.appendChild(c)}google.dp=!0}};google.ps===void 0&&(google.ps=[]);function h(){var a=u,b=function(){};google.lx=google.stvsc?b:function(){k(a);google.lx=b};google.bx||google.lx()}function l(a,b){b&&(a.src=b);var d=a.onload;a.onload=function(c){d&&d(c);google.ps=google.ps.filter(function(C){return a!==C})};google.ps.push(a);document.body.appendChild(a)}google.as=l;function k(a){google.timers&&google.timers.load&&google.tick&&google.tick("load","xjsls");var b=document.createElement("script");b.onerror=function(){google.ple=1};b.onload=function(){google.ple=0};google.xjsus=void 0;l(b,a);google.aple=-1;google.dp=!0};function m(a){var b=a.getAttribute("jscontroller");return(b==="UBXHI"||b==="R3fhkb"||b==="TSZEqd")&&a.hasAttribute("data-src")}function n(){for(var a=document.getElementsByTagName("img"),b=0,d=a.length;b<d;b++){var c=a[b];if(c.hasAttribute("data-lzy_")&&Number(c.getAttribute("data-atf"))&1&&!m(c))return!0}return!1}for(var p=document.getElementsByTagName("img"),q=0,r=p.length;q<r;++q){var t=p[q];Number(t.getAttribute("data-atf"))&1&&m(t)&&(t.src=t.getAttribute("data-src"))};var w,x,y,z,A,B;function D(){google.xjsu=u;e._F_jsUrl=u;A=function(){h()};w=!1;x=(st===1||st===3)&&!!google.caft&&!n();y=f();z=(st===2||st===3)&&!!y&&!n();B=pod}function E(){w||x||z||(A(),w=!0)}setTimeout(function(){google&&google.tick&&google.timers&&google.timers.load&&google.tick("load","xjspls");D();if(x||z){if(x){var a=function(){x=!1;E()};google.caft(a);window.setTimeout(a,amd)}z&&(a=function(){z=!1;E()},y.cbvi.push(a),window.setTimeout(a,mmd));B&&(w||g())}else A()},0);})();window._ = window._ || {};window._DumpException = _._DumpException = function(e){throw e;};window._s = window._s || {};_s._DumpException = _._DumpException;window._qs = window._qs || {};_qs._DumpException = _._DumpException;(function(){var t=[4,16777216,0,0,0,0,0,0,0,2080,536870912,29884416,335982624,147456,2052,8,0,36864,135270488,570425344,67111151,35592,3008];window._F_toggles = window._xjs_toggles = t;})();window._F_installCss = window._F_installCss || function(css){};(function(){google.jl={bfl:0,dw:false,ine:false,ubm:false,uwp:true,vs:false};})();(function(){var pmc='{\x22d\x22:{},\x22sb_he\x22:{\x22agen\x22:false,\x22cgen\x22:false,\x22client\x22:\x22heirloom-hp\x22,\x22dh\x22:true,\x22ds\x22:\x22\x22,\x22fl\x22:true,\x22host\x22:\x22google.com\x22,\x22jsonp\x22:true,\x22msgs\x22:{\x22cibl\x22:\x22\\u0938\\u094d\\u092a\\u0937\\u094d\\u091f \\u0916\\u094b\\u091c\\u0940\x22,\x22dym\x22:\x22\\u0915\\u0947 \\u0924\\u092a\\u093e\\u0908\\u0902\\u0932\\u0947 \\u0916\\u094b\\u091c\\u094d\\u0928 \\u0932\\u093e\\u0917\\u094d\\u0928\\u0941\\u092d\\u090f\\u0915\\u094b \\u0915\\u0941\\u0930\\u093e \\u092f\\u094b \\u0939\\u094b:\x22,\x22lcky\x22:\x22\\u092e \\u092d\\u093e\\u0917\\u094d\\u092f\\u092e\\u093e\\u0928\\u0940 \\u0905\\u0928\\u0941\\u092d\\u0942\\u0924\\u093f \\u0917\\u0930\\u093f\\u0930\\u0939\\u0947\\u091b\\u0941\x22,\x22lml\x22:\x22\\u0925\\u092a \\u091c\\u093e\\u0928\\u0915\\u093e\\u0930\\u0940\x22,\x22psrc\x22:\x22\\u092f\\u094b \\u0916\\u094b\\u091c\\u0940 \\u003Ca href\x3d\\\x22/history\\\x22\\u003E \\u0924\\u092a\\u093e\\u0908\\u0915\\u094b \\u0935\\u0947\\u092c \\u0907\\u0924\\u093f\\u0939\\u093e\\u0938\\u003C/a\\u003E\\u092c\\u093e\\u091f \\u0939\\u091f\\u093e\\u0907\\u092f\\u094b\x22,\x22psrl\x22:\x22\\u0939\\u091f\\u093e\\u0909\\u0928\\u0941\\u0939\\u094b\\u0938\x22,\x22sbit\x22:\x22\\u091a\\u093f\\u0924\\u094d\\u0930\\u0926\\u094d\\u0935\\u093e\\u0930\\u093e \\u0916\\u094b\\u091c\\u094d\\u0928\\u0941\\u0939\\u094b\\u0938\\u094d\x22,\x22srch\x22:\x22Google \\u0916\\u094b\\u091c\\u0940\x22},\x22ovr\x22:{},\x22pq\x22:\x22\x22,\x22rfs\x22:[],\x22stok\x22:\x22NLaZs-UCujx08vsRlcohK3-uvSY\x22}}';google.pmc=JSON.parse(pmc);})();(function(){var b=function(a){var c=0;return function(){return c<a.length?{done:!1,value:a[c++]}:{done:!0}}};
var e=this||self;var g,h;a:{for(var k=["CLOSURE_FLAGS"],l=e,n=0;n<k.length;n++)if(l=l[k[n]],l==null){h=null;break a}h=l}var p=h&&h[610401301];g=p!=null?p:!1;var q,r=e.navigator;q=r?r.userAgentData||null:null;function t(a){return g?q?q.brands.some(function(c){return(c=c.brand)&&c.indexOf(a)!=-1}):!1:!1}function u(a){var c;a:{if(c=e.navigator)if(c=c.userAgent)break a;c=""}return c.indexOf(a)!=-1};function v(){return g?!!q&&q.brands.length>0:!1}function w(){return u("Safari")&&!(x()||(v()?0:u("Coast"))||(v()?0:u("Opera"))||(v()?0:u("Edge"))||(v()?t("Microsoft Edge"):u("Edg/"))||(v()?t("Opera"):u("OPR"))||u("Firefox")||u("FxiOS")||u("Silk")||u("Android"))}function x(){return v()?t("Chromium"):(u("Chrome")||u("CriOS"))&&!(v()?0:u("Edge"))||u("Silk")}function y(){return u("Android")&&!(x()||u("Firefox")||u("FxiOS")||(v()?0:u("Opera"))||u("Silk"))};var z=v()?!1:u("Trident")||u("MSIE");y();x();w();var A=!z&&!w();function D(a){if(/-[a-z]/.test("ved"))return null;if(A&&a.dataset){if(y()&&!("ved"in a.dataset))return null;a=a.dataset.ved;return a===void 0?null:a}return a.getAttribute("data-"+"ved".replace(/([A-Z])/g,"-$1").toLowerCase())};var E=[],F=null;function G(a){a=a.target;var c=performance.now(),f=[],H=f.concat,d=E;if(!(d instanceof Array)){var m=typeof Symbol!="undefined"&&Symbol.iterator&&d[Symbol.iterator];if(m)d=m.call(d);else if(typeof d.length=="number")d={next:b(d)};else throw Error("b`"+String(d));for(var B=[];!(m=d.next()).done;)B.push(m.value);d=B}E=H.call(f,d,[c]);if(a&&a instanceof HTMLElement)if(a===F){if(c=E.length>=4)c=(E[E.length-1]-E[E.length-4])/1E3<5;if(c){c=google.getEI(a);a.hasAttribute("data-ved")?f=a?D(a)||"":"":f=(f=
a.closest("[data-ved]"))?D(f)||"":"";f=f||"";if(a.hasAttribute("jsname"))a=a.getAttribute("jsname");else{var C;a=(C=a.closest("[jsname]"))==null?void 0:C.getAttribute("jsname")}google.log("rcm","&ei="+c+"&tgtved="+f+"&jsname="+(a||""))}}else F=a,E=[c]}window.document.addEventListener("DOMContentLoaded",function(){document.body.addEventListener("click",G)});}).call(this);</script></body></html>
```
---
#### Example 3: Download an object

```java
import java.io.*;
import java.net.*;

public class ContentGetter {
    public static void main(String[] args) {
        try {
            // Open the URL and retrieve content
            URL url = new URL("https://www.oreilly.com");

            // Get the content from the URL as an Object
            Object content = url.getContent();

            // Print the class name of the content object
            System.out.println("I got a " + content.getClass().getName());
        } catch (MalformedURLException ex) {
            // Handle malformed URL error
            System.err.println("The provided URL is not a valid URL: " + ex.getMessage());
        } catch (IOException ex) {
            // Handle other I/O exceptions (e.g., network issues)
            System.err.println("Error occurred: " + ex.getMessage());
        }
    }
}

```

#### Expected Output:

```
I got a sun.net.www.protocol.http.HttpURLConnection$HttpInputStream
```

---
#### Example 4. The parts of a URL
```java
import java.net.*;

public class URLSplitter {
    public static void main(String[] args) {
        try {
            // Create a URL object for a sample URL
            URL url = new URL("https://www.example.com:8080/path/to/resource?name=SharatMaharjan#section");

            // Print the entire URL
            System.out.println("The URL is: " + url);

            // Print the scheme (protocol)
            System.out.println("The scheme is: " + url.getProtocol());

            // Print user info (if available)
            System.out.println("The user info is: " + url.getUserInfo());

            // Print the host (domain name)
            System.out.println("The host is: " + url.getHost());

            // Print the port number
            System.out.println("The port is: " + url.getPort());

            // Print the path of the resource
            System.out.println("The path is: " + url.getPath());

            // Print the reference (fragment identifier, if available)
            System.out.println("The ref (fragment) is: " + url.getRef());

            // Print the query string (if available)
            System.out.println("The query string is: " + url.getQuery());
        } catch (MalformedURLException ex) {
            System.err.println("It is not a URL I understand.");
        }
        System.out.println();
    }
}

```

```
getProtocol() returns the protocol part of the URL (e.g., https for secure HTTP).
getUserInfo() would return any username and password specified in the URL (e.g., user:password if provided). If not present, it returns null.
getHost() returns the host or domain of the URL (e.g., www.example.com).
getPort() returns the port number. If no port is specified, it returns -1 (indicating the default port for the protocol).
getPath() returns the path part of the URL (e.g., /path/to/resource).
getRef() returns the fragment (or anchor) part of the URL, which is the part after the # symbol (e.g., section).
getQuery() returns the query string (e.g., name=SharatMaharjan).
```

#### Expected Output:
```
The URL is: https://www.example.com:8080/path/to/resource?name=SharatMaharjan#section
The scheme is: https
The user info is: null
The host is: www.example.com
The port is: 8080
The path is: /path/to/resource
The ref (fragment) is: section
The query string is: name=SharatMaharjan
```
---
Example 5: Checking URL Equality: Are http://www.ibiblio.org and http://ibiblio.org the same?
```java
import java.net.*;

public class URLEquality {
    public static void main(String[] args) {
        try {
            // Define two URL objects
            URL www = new URL("http://www.ibiblio.org/");
            URL ibiblio = new URL("http://ibiblio.org/");
            
            // Compare the two URLs using equals()
            if (ibiblio.equals(www)) {
                System.out.println(ibiblio + " is the same as " + www);
            } else {
                System.out.println(ibiblio + " is not the same as " + www);
            }
        } catch (MalformedURLException ex) {
            System.err.println("Invalid URL format: " + ex.getMessage());
        }
    }
}

```

#### Expected Output:

```
http://ibiblio.org/ is the same as http://www.ibiblio.org/
```

---
Example 6: The parts of a URI

```java
import java.net.*;

public class URISplitter {
    public static void main(String[] args) {
        try {
            URI u = new URI("https://www.prime.edu.np/");
            // URI u = new URI("mailto:someone@example.com");
            System.out.println("The URI is " + u);
            
            if (u.isOpaque()) { // URI does not describe a path to a resource
                System.out.println("This is an opaque URI.");
                System.out.println("The scheme is " + u.getScheme());
                System.out.println("The scheme specific part is " + u.getSchemeSpecificPart());
                System.out.println("The fragment ID is " + u.getFragment());
            } else {
                System.out.println("This is a hierarchical URI.");
                System.out.println("The scheme is " + u.getScheme());
                System.out.println("The host is " + u.getHost());
                System.out.println("The user info is " + u.getUserInfo());
                System.out.println("The port is " + u.getPort());
                System.out.println("The path is " + u.getPath());
                System.out.println("The query string is " + u.getQuery());
                System.out.println("The fragment ID is " + u.getFragment());
            }
        } catch (URISyntaxException ex) {
            System.err.println("Does not seem to be a valid URI.");
        }
    }
}

```

```
Types of URIs:
Opaque URI: Does not have a hierarchical structure (e.g., mailto: or telnet: URIs).
Hierarchical URI: Has a clear structure that includes a scheme (e.g., http, https), host, path, and optionally a port, query string, and fragment identifier.
Methods used in the program:
isOpaque(): Checks if the URI is opaque (not hierarchical).
getScheme(): Retrieves the scheme (protocol) of the URI.
getSchemeSpecificPart(): Retrieves the scheme-specific part of the URI.
getHost(), getPort(), getPath(), getUserInfo(), getQuery(), getFragment(): Retrieve different components of the URI.
```

#### Expected Ouput:
```
The URI is https://www.prime.edu.np/
This is a hierarchical URI.
The scheme is https
The host is www.prime.edu.np
The user info is null
The port is -1
The path is /
The query string is null
The fragment ID is null
```

---
#### Example 7: x-www-form-urlencoded strings
```java
import java.io.*;
import java.net.*;

public class Example7 {
    public static void main(String[] args) {
        try {
            System.out.println(URLEncoder.encode("This string has spaces", "UTF-8"));
            System.out.println(URLEncoder.encode("This*string*has*asterisks", "UTF-8"));
            System.out.println(URLEncoder.encode("This%string%has%percent%signs", "UTF-8"));
            System.out.println(URLEncoder.encode("This+string+has+pluses", "UTF-8"));
            System.out.println(URLEncoder.encode("This/string/has/slashes", "UTF-8"));
            System.out.println(URLEncoder.encode("This\"string\"has\"quote\"marks", "UTF-8"));
            System.out.println(URLEncoder.encode("This:string:has:colons", "UTF-8"));
            System.out.println(URLEncoder.encode("This~string~has~tildes", "UTF-8"));
            System.out.println(URLEncoder.encode("This(string)has(parentheses)", "UTF-8"));
            System.out.println(URLEncoder.encode("This.string.has.periods", "UTF-8"));
            System.out.println(URLEncoder.encode("This=string=has=equals=signs", "UTF-8"));
            System.out.println(URLEncoder.encode("This&string&has&ampersands", "UTF-8"));
            System.out.println(URLEncoder.encode("Thiséstringéhasénon-ASCII characters", "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Encoding not supported.");
        }
    }
}

```
```
Spaces: The space character is encoded as %20.
Asterisks (*): Asterisks are left unchanged because they are safe for URLs but might be encoded depending on context.
Percent signs (%): These characters are encoded as %25 to avoid confusion with URL-encoding itself.
Pluses (+): Pluses are encoded as %2B.
Slashes (/): Slashes are encoded as %2F.
Quotes ("): Double quotes are encoded as %22.
Colons (:): Colons are encoded as %3A.
Tildes (~): Tildes are encoded as %7E.
Parentheses (()): Parentheses are encoded as %28 and %29.
Periods (.): Periods are left unchanged but could be encoded in some cases.
Equals signs (=): Equals signs are encoded as %3D.
Ampersands (&): Ampersands are encoded as %26.
Non-ASCII characters (like é): These are encoded in their UTF-8 percent-encoded format (e.g., %C3%A9 for é).
```

#### Expected Output:
#### Example 8: URLDecoder
```
This%20string%20has%20spaces
This%2Astring%2Ahas%2Aasterisks
This%25string%25has%25percent%25signs
This%2Bstring%2Bhas%2Bpluses
This%2Fstring%2Fhas%2Fslashes
This%22string%22has%22quote%22marks
This%3Astring%3Ahas%3Acolons
This%7Estring%7Ehas%7Etildes
This%28string%29has%28parentheses%29
This.string.has.periods
This%3Dstring%3Dhas%3Dequals%3Dsigns
This%26string%26has%26ampersands
This%C3%A9string%C3%A9has%C3%A9non-ASCII%20characters

```

---

```java
import java.io.*;
import java.net.*;

public class ExampleDecoder {
    public static void main(String[] args) {
        try {
            // Decode a string where '+' is used for spaces
            System.out.println(URLDecoder.decode("This+string+has+spaces", "UTF-8"));
            
            // Decode a string where '%25' represents '%'
            System.out.println(URLDecoder.decode("This%25string%25has%25percent%25signs", "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Encoding not supported.");
        }
    }
}

```

#### Expected Output:

```
This string has spaces
This%string%has%percent%signs
```

---
