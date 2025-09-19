# Unit 2: Internet Addresses

## 1. Print the address of `www.javatpoint.com`

```java
import java.net.InetAddress;
import java.net.UnknownHostException;

public class JavaInternetAddressByName {
    public static void main(String[] args) {
        try {
            // Get IP address of the host www.javatpoint.com
            InetAddress address = InetAddress.getByName("www.javatpoint.com");
            
            // Print the IP address
            System.out.println("Address of www.javatpoint.com: " + address);
        } catch (UnknownHostException e) {
            // If host not found
            System.out.println("Couldn't find the host.");
        }
    }
}
```

**Sample Output:**

```
Address of www.javatpoint.com: www.javatpoint.com/172.67.160.113
```

---

## 2. Find the hostname of an IP address

```java
import java.net.*;

public class ReverseTest {
    public static void main(String[] args) {
        try {
            // Get InetAddress object for the given IP
            InetAddress machine = InetAddress.getByName("104.21.79.8");
            
            // Get the hostname of the given IP
            System.out.println("Hostname of 104.21.79.8: " + machine.getCanonicalHostName());
        } catch (UnknownHostException e) {
            System.out.println("No hostname found.");
        }
    }
}
```

**Sample Output:**

```
Hostname of 104.21.79.8: www.javatpoint.com
```

---

## 3. Find the IP address of the local machine

```java
import java.net.*;

public class IPLocal {
    public static void main(String[] args) {
        try {
            // Get InetAddress object for the local machine
            InetAddress machine = InetAddress.getLocalHost();
            
            // Print local IP address
            System.out.println("Local machine IP Address: " + machine.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("No hostname found.");
        }
    }
}
```

**Sample Output:**

```
Local machine IP Address: 192.168.1.10
```

---

## 4. Determine whether an IP address is IPv4 or IPv6

```java
import java.net.*;

public class AddressTest {
    public static void main(String[] args) {
        try {
            // Get InetAddress of a domain
            InetAddress machine = InetAddress.getByName("www.prime.edu.np");
            
            // Get the raw IP address bytes
            byte[] address = machine.getAddress();
            
            // Check length of the byte array
            if(address.length == 4)
                System.out.println("IPv4 is being used.");
            else
                System.out.println("IPv6 is being used.");
        } catch (UnknownHostException e) {
            System.out.println("No hostname found.");
        }
    }
}
```

**Sample Output:**

```
IPv4 is being used.
```

---

## 5. Check if `www.ibiblio.org` and `helios.ibiblio.org` are the same

```java
import java.net.*;

public class IBiblioAliases {
    public static void main(String args[]) {
        try {
            // Get InetAddress of both hosts
            InetAddress ibiblio = InetAddress.getByName("www.ibiblio.org");
            InetAddress helios = InetAddress.getByName("helios.ibiblio.org");

            // Compare the two addresses
            if (ibiblio.equals(helios)) {
                System.out.println("www.ibiblio.org is the same as helios.ibiblio.org");
            } else {
                System.out.println("www.ibiblio.org is not the same as helios.ibiblio.org");
            }
        } catch (UnknownHostException ex) {
            System.out.println("Host lookup failed.");
        }
    }
}
```

**Sample Output:**

```
www.ibiblio.org is the same as helios.ibiblio.org
```

---

## 6. List all the network interfaces

```java
import java.net.*;
import java.util.*;

public class InterfaceLister {
    public static void main(String[] args) throws SocketException {
        // Get all network interfaces on the machine
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        
        // Loop through interfaces
        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            System.out.println("Interface: " + ni);
        }
    }
}
```

**Sample Output:**

```
Interface: name:eth0 (eth0)
Interface: name:lo (lo)
```

---

## 7. Spam Check Program

```java
import java.net.*;

public class SpamCheck {
    public static final String BLACKHOLE = "sbl.spamhaus.org";

    public static void main(String[] args) throws UnknownHostException {
        // Loop through all given arguments (IP addresses/domains)
        for (String arg: args) {
            if (isSpammer(arg)) {
                System.out.println(arg + " is a known spammer.");
            } else {
                System.out.println(arg + " appears legitimate.");
            }
        }
    }

    private static boolean isSpammer(String arg) {
        try {
            // Convert domain/IP to InetAddress
            InetAddress address = InetAddress.getByName(arg);
            
            // Get IP address bytes
            byte[] quad = address.getAddress();
            String query = BLACKHOLE;

            // Reverse the IP and append the blacklist domain
            for (byte octet : quad) {
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                query = unsignedByte + "." + query;
            }
            
            // Lookup in the blacklist
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }
}
```

**Sample Output (running with `java SpamCheck 104.21.79.8`):**

```
104.21.79.8 appears legitimate.
```

---

## 8. Process web server log files

```java
import java.io.*;
import java.net.*;

public class Weblog {
    public static void main(String[] args) {
        try (FileInputStream fin = new FileInputStream(args[0]);
             Reader in = new InputStreamReader(fin);
             BufferedReader bin = new BufferedReader(in)) {
            
            // Read each line of the log file
            for (String entry = bin.readLine(); entry != null; entry = bin.readLine()) {
                // Extract IP (first word before space)
                int index = entry.indexOf(' ');
                String ip = entry.substring(0, index);
                String theRest = entry.substring(index);
                
                try {
                    // Convert IP to hostname
                    InetAddress address = InetAddress.getByName(ip);
                    System.out.println(address.getHostName() + theRest);
                } catch (UnknownHostException ex) {
                    // If hostname not found, print original entry
                    System.err.println(entry);
                }
            }
        } catch (IOException ex) {
            System.out.println("Exception: " + ex);
        }
    }
}
```

**Sample Log File Input (`access.log`):**

```
104.21.79.8 - - [18/Sep/2025:10:00:00] "GET /index.html"
```

**Sample Output:**

```
www.javatpoint.com - - [18/Sep/2025:10:00:00] "GET /index.html"
```

---

# Unit 3: URLs and URIs

### Lab 1: Which protocols does a virtual machine support?

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
### 2. Lab 2: Download a web page
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
#### Lab 3: Download an object

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
#### Lab 4. The parts of a URL
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
Lab 5: Checking URL Equality: Are http://www.ibiblio.org and http://ibiblio.org the same?
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
Lab 6: The parts of a URI

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
#### Lab 7: x-www-form-urlencoded strings
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

#### Lab 8: URLDecoder

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

# Unit 4: HTTP

## What are significance to control HTTP Keep-Alive system properties. Write a program for a cookie policy that blocks all .gov cookies but allows others.

### 1st Part: Significance of Controlling HTTP Keep-Alive System Properties

**HTTP Keep-Alive** is a feature that allows a **single TCP connection** to be reused for multiple HTTP requests/responses between the client and server, instead of creating a new connection for every request.

### **Significance of Controlling Keep-Alive Properties**

1. **Performance Improvement**

   * Reusing connections reduces the overhead of repeatedly creating and tearing down TCP connections.
   * Faster page loads due to reduced latency.

2. **Resource Management**

   * If too many connections remain open (idle), server resources (threads, sockets, memory) may be wasted.
   * By controlling keep-alive timeout and max requests, servers can free resources.

3. **Load Balancing & Scalability**

   * In high-traffic systems, properly tuned keep-alive properties help maintain optimal throughput without exhausting system resources.

4. **Energy Efficiency**

   * On mobile and IoT devices, fewer TCP handshakes mean lower CPU usage and less battery drain.

5. **Custom Control via System Properties**
   In Java, we can configure keep-alive using system properties like:

   * `http.keepAlive` → `true/false` (default is `true`)
   * `http.maxConnections` → maximum connections allowed per destination host
   * `http.keepAlive.duration` (implementation-specific) → how long to keep connection alive

---

### 2nd Part: Cookie Policy to Block `.gov` Cookies

We’ll implement a **custom cookie policy** using `java.net.CookiePolicy`.
This policy **blocks all cookies from `.gov` domains** while allowing others.

```java
import java.net.*;
import java.util.*;

public class CustomCookiePolicy {
    public static void main(String[] args) throws Exception {
        // Create CookieManager with custom policy
        CookieManager manager = new CookieManager(null, new CookiePolicy() {
            @Override
            public boolean shouldAccept(URI uri, HttpCookie cookie) {
                // Block all cookies from domains ending with ".gov"
                if (uri.getHost().endsWith(".gov")) {
                    System.out.println("Blocked cookie from: " + uri.getHost() + " → " + cookie);
                    return false;
                }
                // Allow all other cookies
                System.out.println("Allowed cookie from: " + uri.getHost() + " → " + cookie);
                return true;
            }
        });

        // Set default cookie handler with our policy
        CookieHandler.setDefault(manager);

        // Example request to test the cookie policy
        URL url = new URL("http://example.com"); // Replace with actual test site
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // Read response using BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();

        System.out.println("Request finished.");
    }
}
```

---

### Explanation:

1. `CookieManager` manages cookies in Java.
2. `CookiePolicy` interface allows we to define rules:

   * Here, we override `shouldAccept()`.
   * If the host ends with `.gov`, cookies are **blocked**.
   * Otherwise, cookies are **allowed**.
3. `CookieHandler.setDefault(manager)` sets our custom cookie policy as global.
4. When making HTTP requests with `HttpURLConnection`, the policy is automatically applied.

---

### 🖥️ Sample Output

If visiting `http://whitehouse.gov`:

```
Blocked cookie from: whitehouse.gov → sessionid=XYZ123
```

If visiting `http://example.com`:

```
Allowed cookie from: example.com → user=sharat
```



---
# Unit 5: URLConnection

The `URLConnection` class in Java is used to establish a connection between the application and a URL resource. It allows retrieving data from web pages, such as content type, header fields, and input streams to read the page's content.

Note: Differences between URL and URLConnection.
- URLConnection provides access to the HTTP header.
- URLConnection can configure the request parameters sent to the server.
- URLConnection can write data to the server as well as read data from the server.

### **Lab 1: Demonstrating `URLConnection` in Java**

```java
import java.io.*;
import java.net.*;

public class URLConnectionExample {
    public static void main(String[] args) {
        try {
            // Define the URL to connect to
            URL url = new URL("https://www.prime.edu.np/");
            
            // Open a connection to the specified URL
            URLConnection urlConnection = url.openConnection();
            
            // Retrieve and print the content type of the URL resource
            System.out.println("Content Type: " + urlConnection.getContentType());
            
        } catch (MalformedURLException e) {
            // Handle incorrect or badly formatted URLs
            System.err.println("Error: The URL is not properly formatted.");
        } catch (IOException e) {
            // Handle IO errors such as connection failures
            System.err.println("Error: Unable to connect to the URL. " + e.getMessage());
        }
    }
}
```

### **Sample Output**

If the connection is successful:

```
Content Type: text/html; charset=UTF-8
```

If the URL is incorrect:

```
Error: The URL is not properly formatted.
```

If there's a connection issue:

```
Error: Unable to connect to the URL. Connection timed out.
```

---

### **Lab 2: Downloading a Web Page Using `URLConnection` in Java**

```java
import java.io.*;
import java.net.*;

public class DownloadWebPage {
    public static void main(String[] args) {
        try {
            // Create a URL object pointing to the desired web page
            URL url = new URL("https://www.prime.edu.np/");
            
            // Open a connection to the specified URL
            URLConnection urlConnection = url.openConnection();
            
            // Create a BufferedReader to read the web page content line by line
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            
            String inputLine;
            
            // Read each line from the web page and print it
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            
            // Close the BufferedReader
            in.close();
            
        } catch (MalformedURLException e) {
            // Handle incorrect or malformed URLs
            System.err.println("Error: The URL is not properly formatted.");
        } catch (IOException e) {
            // Handle connection or reading issues
            System.err.println("Error: Unable to retrieve web page content. " + e.getMessage());
        }
    }
}
```

### **Sample Output (Partial HTML Content of the Page)**

```html
<!doctype html>
<html dir="ltr" lang="en-US" prefix="og: https://ogp.me/ns#">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="profile" href="https://gmpg.org/xfn/11">
	 <title>Prime College</title>
<link rel="icon" href="https://prime.edu.np/wp-content/themes/prime-college/assets/img/favicon.png">
    <!-- -----Style Library----- -->
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://prime.edu.np/wp-content/themes/prime-college/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://prime.edu.np/wp-content/themes/prime-college/assets/vendor/fontawesome/css/all.min.css">
    <link
  rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"
/>

              ........

</body>
</html>
</div>
```

If the URL is incorrect:

```
Error: The URL is not properly formatted.
```

If there's a connection issue:

```
Error: Unable to retrieve web page content. Connection timed out.
```

---

### **Lab 3: Retrieving HTTP Headers Using `URLConnection` in Java**

The `URLConnection` class provides methods to retrieve HTTP headers from a given URL, such as content type, encoding, modification date, expiration date, and content length.

```java
import java.net.*;
import java.util.Date;
import java.io.*;

public class URLHeaderInfo {
    public static void main(String[] args) {
        try {
            // Create a URL object pointing to the desired web page
            URL url = new URL("https://www.prime.edu.np/");
            
            // Open a connection to the URL
            URLConnection urlConnection = url.openConnection();
            
            // Display content type of the resource
            System.out.println("Content-type: " + urlConnection.getContentType());
            
            // Check and display content encoding if available
            if (urlConnection.getContentEncoding() != null) {
                System.out.println("Content-encoding: " + urlConnection.getContentEncoding());
            }
            
            // Check and display the date of the resource if available
            if (urlConnection.getDate() != -1) {
                System.out.println("Date: " + new Date(urlConnection.getDate()));
            }
            
            // Check and display the last modified date if available
            if (urlConnection.getLastModified() != -1) {
                System.out.println("Last modified: " + new Date(urlConnection.getLastModified()));
            }
            
            // Check and display expiration date if available
            if (urlConnection.getExpiration() != -1) {
                System.out.println("Expiration date: " + new Date(urlConnection.getExpiration()));
            }
            
            // Check and display content length if available
            if (urlConnection.getContentLength() != -1) {
                System.out.println("Content-length: " + urlConnection.getContentLength());
            }
            
        } catch (MalformedURLException e) {
            // Handle an invalid URL format
            System.err.println("Error: It is not a valid URL.");
        } catch (IOException e) {
            // Handle input/output errors such as connection failure
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```

### **Sample Output**

```
Content-type: text/html; charset=UTF-8
Date: Mon Jan 27 16:49:13 NPT 2025
Last modified: Thu Jan 01 05:30:00 NPT 1970
Expiration date: Thu Jan 01 05:30:00 NPT 1970
```

If the URL is incorrect:

```
Error: It is not a valid URL.
```

If there's a connection issue:

```
Error: Connection refused
```

---

### **Lab 4: Printing the Entire HTTP Header Using `URLConnection` in Java**

The `URLConnection` class provides methods to access HTTP headers of a web page. HTTP headers contain key-value pairs providing information such as content type, date, server details, and more.


```java
import java.net.*;
import java.io.*;

public class HTTPHeaderPrinter {
    public static void main(String[] args) {
        try {
            // Create a URL object pointing to the target web page
            URL url = new URL("https://www.prime.edu.np/");
            
            // Open a connection to the specified URL
            URLConnection urlConnection = url.openConnection();
            
            // Variable to iterate through header fields
            int i = 1;
            
            // Loop through HTTP headers and print key-value pairs
            while (urlConnection.getHeaderField(i) != null) {
                System.out.println(urlConnection.getHeaderFieldKey(i) + ": " + urlConnection.getHeaderField(i));
                i++;
            }
            
        } catch (MalformedURLException e) {
            // Handle incorrect URL format
            System.err.println("Error: It is not a valid URL.");
        } catch (IOException e) {
            // Handle connection or input-output errors
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```

### **Sample Output**

```
Date: Mon, 27 Jan 2025 11:05:31 GMT
Content-Type: text/html; charset=UTF-8
Transfer-Encoding: chunked
Connection: keep-alive
x-powered-by: PHP/7.4.33
link: <https://prime.edu.np/wp-json/>; rel="https://api.w.org/"
link: <https://prime.edu.np/wp-json/wp/v2/pages/7>; rel="alternate"; title="JSON"; type="application/json"
link: <https://prime.edu.np/>; rel=shortlink
vary: Accept-Encoding
x-turbo-charged-by: LiteSpeed
cf-cache-status: DYNAMIC
Report-To: {"endpoints":[{"url":"https:\/\/a.nel.cloudflare.com\/report\/v4?s=0r%2B2ttxgMyl%2BmrpL3yn3MDAbG6452kC%2BbhhOsRSLasseHEogodbpW8mVk6TVnleQdO5dpiivZNDRTpS8Fi4ae%2F4Eqiy%2FO9GUob9STDruGL5yyHKXI2VQerEwCoAz4XA%3D"}],"group":"cf-nel","max_age":604800}
NEL: {"success_fraction":0,"report_to":"cf-nel","max_age":604800}
Server: cloudflare
CF-RAY: 9088449d59f22789-LYS
alt-svc: h3=":443"; ma=86400
server-timing: cfL4;desc="?proto=TCP&rtt=191449&min_rtt=189723&rtt_var=42623&sent=6&recv=9&lost=0&retrans=0&sent_bytes=3119&recv_bytes=688&delivery_rate=22026&cwnd=252&unsent_bytes=0&cid=3e51b5ebcb6c6520&ts=1340&x=0"

```

If the URL is incorrect:

```
Error: It is not a valid URL.
```

If there's a connection issue:

```
Error: Connection timed out
```

---


### **Lab 5: Printing the URL of a `URLConnection` in Java**

The `URLConnection` class allows accessing various properties of a web resource, including retrieving the actual URL after establishing a connection. This can be useful in cases where URL redirections occur.


```java
import java.io.*;
import java.net.*;

public class URLPrinter {
    public static void main(String[] args) {
        try {
            // Create a URL object with the target website
            URL url = new URL("http://www.oreilly.com/");
            
            // Open a connection to the specified URL
            URLConnection urlConnection = url.openConnection();
            
            // Print the URL of the connection
            System.out.println("Connected URL: " + urlConnection.getURL());
            
        } catch (IOException e) {
            // Handle connection or input-output errors
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```

### **Sample Output (Expected Output)**

If the URL is accessed successfully:

```
Connected URL: http://www.oreilly.com/
```

If there is a redirection (e.g., to HTTPS):

```
Connected URL: https://www.oreilly.com/
```

If there is a connection issue:

```
Error: www.oreilly.com: Name or service not known
```

---

### **Lab 6:Program to print all response from server**

```java
import java.io.*;
import java.net.*;

public class Example6 {
    public static void main(String[] args) {
        try {
            // Define the URL to connect to
            URL url = new URL("http://www.prime.edu.np");

            // Open an HTTP connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Get the HTTP response code (e.g., 200 for success)
            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();

            // Print the HTTP response status line
            System.out.println("HTTP/1.x " + responseCode + " " + responseMessage);

            // Print all HTTP headers
            int headerIndex = 1;
            while (connection.getHeaderField(headerIndex) != null) {
                System.out.println(connection.getHeaderFieldKey(headerIndex) + ": " + connection.getHeaderField(headerIndex));
                headerIndex++;
            }

            System.out.println("\n--- Response Content ---");

            // Read and print the response body (HTML content)
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();  // Close the reader after reading the response

        } catch (MalformedURLException e) {
            System.err.println("Invalid URL format.");
        } catch (IOException e) {
            System.err.println("Error in connection: " + e.getMessage());
        }
    }
}
```

### **Sample Output**

```
HTTP/1.x 200 OK
Date: Mon, 27 Jan 2025 11:08:36 GMT
Content-Type: text/html; charset=UTF-8
Transfer-Encoding: chunked
Connection: keep-alive
x-powered-by: PHP/7.4.33
link: <https://prime.edu.np/wp-json/>; rel="https://api.w.org/"
link: <https://prime.edu.np/wp-json/wp/v2/pages/7>; rel="alternate"; title="JSON"; type="application/json"
link: <https://prime.edu.np/>; rel=shortlink
vary: Accept-Encoding
x-turbo-charged-by: LiteSpeed
cf-cache-status: DYNAMIC
Report-To: {"endpoints":[{"url":"https:\/\/a.nel.cloudflare.com\/report\/v4?s=aJ9MqdIY1%2FroQB4xKHk%2BMO%2Bly6zPzRnDqVJroiAYsUU2FX%2BXvsThyvBimV8DUNqWW2UPWrY037t1VZ9LRfomIspPWm1S2PLOLpGZxGD83Z2EHPE2OXCPS5RQML%2Byy70%3D"}],"group":"cf-nel","max_age":604800}
NEL: {"success_fraction":0,"report_to":"cf-nel","max_age":604800}
Server: cloudflare
CF-RAY: 908849257b82e160-MRS
alt-svc: h3=":443"; ma=86400
server-timing: cfL4;desc="?proto=TCP&rtt=133878&min_rtt=132715&rtt_var=50599&sent=6&recv=7&lost=0&retrans=0&sent_bytes=3117&recv_bytes=688&delivery_rate=32370&cwnd=216&unsent_bytes=0&cid=7d07a5b203dc688e&ts=532&x=0"

--- Response Content ---
<!doctype html>
<html dir="ltr" lang="en-US" prefix="og: https://ogp.me/ns#">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="profile" href="https://gmpg.org/xfn/11">
	 <title>Prime College</title>
<link rel="icon" href="https://prime.edu.np/wp-content/themes/prime-college/assets/img/favicon.png">
    <!-- -----Style Library----- -->
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://prime.edu.np/wp-content/themes/prime-college/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://prime.edu.np/wp-content/themes/prime-college/assets/vendor/fontawesome/css/all.min.css">
    <link
  rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"
/>


.....................

</body>
</html>

```
---

# UNIT 6 SOCKET FOR CLIENTS LH - 5HRS
 
    
### LAB 1: Find out which of the first 1,024 ports seem to be hosting TCP servers on a specified host.(PortScanner)
```java
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class PortScanner {

    public static void main(String[] args) {
        // Define the range of ports to scan (1 to 1024)
        int startPort = 1;
        int endPort = 1024;

        // Loop through each port in the specified range
        for (int port = startPort; port <= endPort; port++) {
            try {
                // Attempt to create a socket connection to the specified host and port
                Socket socket = new Socket("localhost", port);
                System.out.println("Server is running on port " + port + " of localhost.");
                socket.close(); // Close the socket after successful connection
            } catch (UnknownHostException e) {
                // Handle the case where the host is unknown
                System.out.println("Unknown host: " + e.getMessage());
                break; // Exit the loop if the host is unknown
            } catch (IOException e) {
                // Handle the case where the port is closed or unreachable
                System.out.println("No server is running on port " + port + " of localhost.");
            }
        }
    }
}

```
### LAB 2: Find out which of the ports at or above 1,024 seem to be hosting TCP servers.

```java
import java.io.IOException;
import java.net.Socket;

public class HighPortScanner {

    public static void main(String[] args) {
        // Define the range of ports to scan (1024 to 65535)
        int startPort = 1024;
        int endPort = 65535;

        // Loop through each port in the specified range
        for (int port = startPort; port <= endPort; port++) {
            try {
                // Attempt to create a socket connection to the specified host and port
                Socket socket = new Socket("localhost", port);
                System.out.println("Server is running on port " + port + " of localhost.");
                socket.close(); // Close the socket after successful connection
            } catch (IOException e) {
                // Port is closed or unreachable, so no action is taken
                // Uncomment the line below to see which ports are closed
                // System.out.println("No server is running on port " + port + " of localhost.");
            }
        }
    }
}

```
  
### LAB 3: WAP to attempt to open a socket for www.prime.edu.np or any other host, and then uses these four methods to print the remote host, the remote port, the local address, and the local port.

```java
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketInfoExample {

    public static void main(String[] args) {
        // Define the host and port to connect to
        String host = "www.prime.edu.np";
        int port = 80;

        try {
            // Attempt to open a socket connection to the specified host and port
            Socket socket = new Socket(host, port);

            // Retrieve and print connection details
            System.out.println("Connected to remote host: " + socket.getInetAddress());
            System.out.println("Remote port: " + socket.getPort());
            System.out.println("Local address: " + socket.getLocalAddress());
            System.out.println("Local port: " + socket.getLocalPort());

            // Close the socket after use
            socket.close();
        } catch (UnknownHostException ex) {
            System.err.println("Error: Unable to find the host '" + host + "'.");
        } catch (IOException ex) {
            System.err.println("Error: Could not connect to the host '" + host + "'.");
            ex.printStackTrace();
        }
    }
}

```
### LAB 4: WAP for EchoClient.
**Echoclient.java**
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) {
        // Define the server address and port
        String serverAddress = "localhost";
        int serverPort = 4567;

        // Declare resources outside the try block to ensure they can be closed in the finally block
        Socket clientSocket = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        Scanner scanner = null;

        try {
            System.out.println("Waiting for connection...");
            clientSocket = new Socket(serverAddress, serverPort); // Connect to the server
            System.out.println("Connected to server...");

            // Set up input and output streams
            br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            pw = new PrintWriter(clientSocket.getOutputStream(), true);

            // Set up scanner to read input from the console
            scanner = new Scanner(System.in);

            // Start communication loop
            while (true) {
                System.out.print("Enter text: ");
                String inputLine = scanner.nextLine(); // Read input from the console

                // Check if the user wants to quit
                if (inputLine.equalsIgnoreCase("quit")) {
                    System.out.println("Closing connection...");
                    break;
                }

                pw.println(inputLine); // Send the input to the server

                String response = br.readLine(); // Read the server's response
                System.out.println("Server: " + response); // Print the server's response
            }
        } catch (UnknownHostException e) {
            System.err.println("Error: Unknown host - " + serverAddress);
        } catch (IOException e) {
            System.err.println("Error: Unable to connect to the server - " + e.getMessage());
        } finally {
            // Close resources in the finally block to ensure they are always closed
            try {
                if (scanner != null) scanner.close();
                if (pw != null) pw.close();
                if (br != null) br.close();
                if (clientSocket != null) clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error: Failed to close resources - " + e.getMessage());
            }
        }
    }
}

```


**EchoSever.java**

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {
        // Define the port on which the server will listen for connections
        int port = 4567;

        // Declare resources outside the try block to ensure they can be closed in the finally block
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            // Create a ServerSocket to listen for incoming connections on the specified port
            serverSocket = new ServerSocket(port);
            System.out.println("EchoServer is running and waiting for connections on port " + port + "...");

            // Accept an incoming client connection
            clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Set up input and output streams for communication with the client
            br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            pw = new PrintWriter(clientSocket.getOutputStream(), true);

            // Start communication loop
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                System.out.println("Received from client: " + inputLine);

                // Echo the received message back to the client
                pw.println(inputLine);
                System.out.println("Sent to client: " + inputLine);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Close resources in the finally block to ensure they are always closed
            try {
                if (pw != null) pw.close();
                if (br != null) br.close();
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                System.err.println("Error: Failed to close resources - " + e.getMessage());
            }
        }
    }
}
```

### Lab 5 WhoIs GUI

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WhoisGUI extends JFrame {

    private JTextField domainField;
    private JTextArea resultArea;

    public WhoisGUI() {
        setTitle("Whois Lookup");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for input components
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel domainLabel = new JLabel("Enter Domain:");
        domainField = new JTextField(20);
        domainField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String domain = domainField.getText().trim();
                if (!domain.isEmpty()) {
                    lookupWhois(domain);
                }
            }
        });

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String domain = domainField.getText().trim();
                if (!domain.isEmpty()) {
                    lookupWhois(domain);
                }
            }
        });

        inputPanel.add(domainLabel);
        inputPanel.add(domainField);
        inputPanel.add(submitButton);

        // Panel for result text area
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());

        JLabel resultLabel = new JLabel("Whois Result:");
        resultArea = new JTextArea(20, 50);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        resultPanel.add(resultLabel, BorderLayout.NORTH);
        resultPanel.add(scrollPane, BorderLayout.CENTER);

        // Adding panels to the main frame
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);
        
        // Scroll to top after updating result
        resultArea.setCaretPosition(0);
    }

    private void lookupWhois(String domain) {
        String whoisServer = "whois.verisign-grs.com";
        int port = 43;

        try (Socket socket = new Socket(whoisServer, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send domain query
            out.println(domain);

            // Receive and display response
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line).append("\n");
            }

            // Update GUI with result and scroll to top
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    resultArea.setText(response.toString());
                    resultArea.setCaretPosition(0); // Scroll to top
                }
            });

        } catch (IOException e) {
        // Handle specific exceptions or provide user feedback
        JOptionPane.showMessageDialog(this, "Error performing Whois lookup:\n" + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace(); // For debugging, log the exception
    }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WhoisGUI gui = new WhoisGUI();
                gui.setVisible(true);
            }
        });
    }
}
```

### Lab 6 NetworkClient

```java
a. simplechatserver.java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SimpleChatServer {

    private static final int PORT = 9000;
    private static List<ClientHandler> clients = new ArrayList<>();
    private static int nextUserId = 1;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                ClientHandler clientHandler = new ClientHandler(clientSocket, "User" + nextUserId);
                nextUserId++;
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private String username;

        public ClientHandler(Socket socket, String username) {
            this.clientSocket = socket;
            this.username = username;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                // Notify client of their username
                out.println("You are connected as: " + username);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(username + ": " + message);
                    broadcastMessage(username + ": " + message, this);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                    out.close();
                    clientSocket.close();
                    clients.remove(this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcastMessage(String message, ClientHandler sender) {
            for (ClientHandler client : clients) {
                if (client != sender) {
                    client.sendMessage(message);
                }
            }
        }

        private void sendMessage(String message) {
            out.println(message);
        }
    }
}

 

b. networkclient.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleNetworkClientGUI extends JFrame {

    private JTextField serverAddressField;
    private JTextField portField;
    private JTextArea chatArea;
    private JTextArea messageArea;
    private JButton sendButton;

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public SimpleNetworkClientGUI() {
        setTitle("Simple Network Client");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for connection details
        JPanel connectionPanel = new JPanel(new FlowLayout());
        serverAddressField = new JTextField("localhost", 15);
        portField = new JTextField("9000", 5);
        JButton connectButton = new JButton("Connect");
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });

        connectionPanel.add(new JLabel("Server Address:"));
        connectionPanel.add(serverAddressField);
        connectionPanel.add(new JLabel("Port:"));
        connectionPanel.add(portField);
        connectionPanel.add(connectButton);

        // Panel for chat area
        JPanel chatPanel = new JPanel(new BorderLayout());
        chatArea = new JTextArea(15, 50);
        chatArea.setEditable(false);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        chatPanel.add(chatScrollPane, BorderLayout.CENTER);

        // Panel for message area and send button
        JPanel messagePanel = new JPanel(new BorderLayout());
        messageArea = new JTextArea(5, 50);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        JScrollPane messageScrollPane = new JScrollPane(messageArea);
        messagePanel.add(messageScrollPane, BorderLayout.CENTER);

        sendButton = new JButton("Send");
        sendButton.setPreferredSize(new Dimension(80, 30));
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        messagePanel.add(sendButton, BorderLayout.EAST);

        // Add panels to the main frame
        add(connectionPanel, BorderLayout.NORTH);
        add(chatPanel, BorderLayout.CENTER);
        add(messagePanel, BorderLayout.SOUTH);
    }

    private void connectToServer() {
        String serverAddress = serverAddressField.getText().trim();
        int port = Integer.parseInt(portField.getText().trim());

        try {
            socket = new Socket(serverAddress, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            appendToChatArea("Connected to server at " + serverAddress + ":" + port);

            // Start a thread to continuously read messages from server
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String message;
                        while ((message = in.readLine()) != null) {
                            appendToChatArea(message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            appendToChatArea("Error connecting to server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        if (out != null) {
            String message = messageArea.getText().trim();
            if (!message.isEmpty()) {
                out.println("You: " + message); // Prefix with "You:"
                appendToChatArea("You: " + message); // Append to chatArea with prefix
                messageArea.setText(""); // Clear message area
            }
        }
    }

    private void appendToChatArea(String message) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                chatArea.append(message + "\n");
                chatArea.setCaretPosition(chatArea.getDocument().getLength());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleNetworkClientGUI clientGUI = new SimpleNetworkClientGUI();
                clientGUI.setVisible(true);
            }
        });
    }
}
```

---

# Unit 7: Server Socket

### Example 1: A Multithreaded Daytime Server

#### a. `DaytimeServer.java`

```java
import java.net.*;
import java.io.*;
import java.util.Date;

public class DaytimeServer {

    public static void main(String[] args) {
        try {
            // Create a server socket listening on port 1234
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Daytime server started on port 1234...");

            // Continuously accept client connections
            while (true) {
                try {
                    // Accept a client connection
                    Socket socket = server.accept();
                    System.out.println("New client connected: " + socket.getInetAddress());

                    // Create a new thread to handle the client request
                    Thread task = new DaytimeThread(socket);
                    task.start();
                } catch (IOException ex) {
                    System.err.println("Error accepting client connection: " + ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.err.println("Could not start server: " + ex.getMessage());
        }
    }

    // Thread class to handle client requests
    private static class DaytimeThread extends Thread {
        private Socket socket;

        DaytimeThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Get the output stream to send data to the client
                Writer out = new OutputStreamWriter(socket.getOutputStream());

                // Get the current date and time
                Date now = new Date();

                // Send the date and time to the client
                out.write(now.toString() + "\r\n");
                out.flush();

                // Close the socket
                socket.close();
                System.out.println("Client disconnected: " + socket.getInetAddress());
            } catch (IOException ex) {
                System.err.println("Error handling client request: " + ex.getMessage());
            }
        }
    }
}
```

---

#### b. `DaytimeClient.java`

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DaytimeClient {

    public static void main(String[] args) {
        String hostname = "localhost"; // Server hostname
        int port = 1234; // Server port

        try (Socket socket = new Socket(hostname, port)) {
            // Read the server's response
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverTime = input.readLine();

            // Print the server's time
            System.out.println("Server time: " + serverTime);
        } catch (IOException ex) {
            System.out.println("Client exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
```

---

### Lab 2: MultiThreaded Binary Server and Client

a. MultiThreadedBinaryServer.java

```java
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedBinaryServer {

    public static void main(String[] args) {
        int port = 12345; // The port number the server will listen on

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Create a new thread for each client connection
                new ServerThread(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            // Send binary data to the client
            byte[] binaryData = {1, 2, 3, 4, 5}; // Example binary data
            out.write(binaryData);
            out.flush();

            System.out.println("Sent binary data to client");

        } catch (IOException ex) {
            System.out.println("ServerThread exception: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                socket.close();
                System.out.println("Client disconnected");
            } catch (IOException ex) {
                System.out.println("Failed to close socket: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}

```

b. BinaryDataClient.java

```java
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class BinaryDataClient {

    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            DataInputStream input = new DataInputStream(socket.getInputStream());

            // Read binary data from the server
            byte[] binaryData = new byte[5];
            input.readFully(binaryData);

            System.out.println("Received binary data from server:");
            for (byte b : binaryData) {
                System.out.print(b + " ");
            }

        } catch (IOException ex) {
            System.out.println("Client exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
```

---
### Lab 3: Logging

a. LoggedServer.java

```java
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggedServer {
    private static final Logger logger = Logger.getLogger(LoggedServer.class.getName());

    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("Server is listening on port " + port);

            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    logger.info("New client connected");

                    Thread task = new DaytimeThread(socket);
                    task.start();
                } catch (IOException ex) {
                    logger.log(Level.SEVERE, "Error accepting client connection", ex);
                }
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Couldn't start server", ex);
        }
    }

    private static class DaytimeThread extends Thread {
        private Socket socket;

        DaytimeThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                Writer out = new OutputStreamWriter(socket.getOutputStream());
                Date now = new Date();
                out.write(now.toString() + "\r\n");
                out.flush();
                logger.info("Sent date to client: " + now.toString());
                socket.close();
                logger.info("Client disconnected");
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Error handling client connection", ex);
            }
        }
    }
}
```

b. LoggedClient.java

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggedClient {
    private static final Logger logger = Logger.getLogger(LoggedClient.class.getName());

    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            logger.info("Connected to server");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverTime = input.readLine();
            logger.info("Received server time: " + serverTime);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Client exception", ex);
        }
    }
}
```

---

### Lab 4: Server Socket Options

a. TimeoutServer.java (SO_TIMEOUT)
```
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TimeoutServer {
    public static void main(String[] args) {
        int port = 12345;
        
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setSoTimeout(5000); // Set timeout to 5000 milliseconds (5 seconds)
            System.out.println("TimeoutServer is listening on port " + port);
            
            while (true) {
                try {
                    Socket socket = serverSocket.accept(); // This will block for up to 5 seconds
                    System.out.println("New client connected to TimeoutServer");
                    // Handle the client connection
                } catch (SocketTimeoutException e) {
                    System.out.println("Accept timed out, no incoming connection in 5 seconds");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
```

b. ReuseAddressServer.java (SO_REUSEADDR)
```
import java.io.IOException;
import java.net.ServerSocket;

public class ReuseAddressServer {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setReuseAddress(true); // Enable SO_REUSEADDR
            System.out.println("ReuseAddressServer is listening on port " + port);

            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("New client connected to ReuseAddressServer");
                    // Handle the client connection
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
```

c. ReceiveBufferServer.java (SO_RCVBUF)
```java
import java.io.IOException;
import java.net.ServerSocket;

public class ReceiveBufferServer {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setReceiveBufferSize(65536); // Set receive buffer size to 64 KB
            System.out.println("ReceiveBufferServer is listening on port " + port);

            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("New client connected to ReceiveBufferServer with receive buffer size: " +
                            socket.getReceiveBufferSize());
                    // Handle the client connection
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
```

d. SimpleClient.java
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to the server");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverResponse = input.readLine();
            System.out.println("Server response: " + serverResponse);
        } catch (IOException ex) {
            System.out.println("Client exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
```

---

### Lab 5: HTTPServers

1. SingleFileServer.java
```java
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SingleFileServer {
    public static void main(String[] args) {
        int port = 8080;
        String fileUrl = "https://raw.githubusercontent.com/Sharatmaharjan/Np/main/code/index.html"; // Raw file URL from GitHub

        try {
            // Fetch the HTML content from the URL
            String content = fetchContentFromUrl(fileUrl);
            
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("SingleFileServer is listening on port " + port);

                while (true) {
                    try (Socket socket = serverSocket.accept()) {
                        System.out.println("New client connected");

                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                        // Read the HTTP request (only the first line for simplicity)
                        String requestLine = in.readLine();
                        System.out.println("Request: " + requestLine);

                        if (requestLine != null && requestLine.startsWith("GET")) {
                            // Send HTTP response
                            out.println("HTTP/1.1 200 OK");
                            out.println("Content-Type: text/html");
                            out.println("Content-Length: " + content.length());
                            out.println();
                            out.println(content);
                        }

                        socket.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String fetchContentFromUrl(String fileUrl) throws IOException {
        StringBuilder content = new StringBuilder();
        URL url = new URL(fileUrl);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine).append("\n");
            }
        }
        return content.toString();
    }
}
```

2. Redirector.java
```java
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Redirector {
    public static void main(String[] args) {
        int port = 8080;
        String redirectUrl = "http://example.com";

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Redirector is listening on port " + port);

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("New client connected");

                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                    // Read the HTTP request (only the first line for simplicity)
                    String requestLine = in.readLine();
                    System.out.println("Request: " + requestLine);

                    if (requestLine != null && requestLine.startsWith("GET")) {
                        // Send HTTP redirect response
                        out.println("HTTP/1.1 302 Found");
                        out.println("Location: " + redirectUrl);
                        out.println();
                    }

                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```


3. FullFledgedHttpServer.java
```java
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class FullFledgedHttpServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new RootHandler());
        server.createContext("/hello", new HelloHandler());
        server.setExecutor(null); // creates a default executor
        System.out.println("FullFledgedHttpServer is listening on port " + port);
        server.start();
    }

    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Welcome to the Full-Fledged HTTP Server!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class HelloHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Hello, world!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
```

# Unit 9: Non Blocking I/O

### Lab 1: Non Blocking I/O
a. NonBlockingServer.java
```java
  import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NonBlockingServer {
    public static void main(String[] args) throws IOException {
        // Open a Selector for handling multiple channels in non-blocking mode
        Selector selector = Selector.open();

        // Open a ServerSocketChannel to listen for incoming client connections
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // Bind the server socket to localhost on port 8080
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8080));

        // Configure the server socket channel to operate in non-blocking mode
        serverSocketChannel.configureBlocking(false);

        // Register the server socket channel with the selector for "accept" operations
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // Infinite loop to continuously handle incoming events
        while (true) {
            // Block until at least one channel is ready for an operation
            selector.select();

            // Get the set of keys corresponding to the channels that are ready
            Set<SelectionKey> selectedKeys = selector.selectedKeys();

            // Use an iterator to process each key
            Iterator<SelectionKey> it = selectedKeys.iterator();

            while (it.hasNext()) {
                SelectionKey key = it.next();

                // Check if the key indicates that a new client connection is ready to be accepted
                if (key.isAcceptable()) {
                    // Accept the incoming client connection
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel client = server.accept();

                    // Configure the client socket channel to operate in non-blocking mode
                    client.configureBlocking(false);

                    // Register the client channel with the selector for "read" operations
                    client.register(selector, SelectionKey.OP_READ);
                } 
                // Check if the key indicates that data is available to be read from a client
                else if (key.isReadable()) {
                    // Get the client channel and read data into a buffer
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(256); // Allocate a buffer of size 256 bytes

                    // Read data from the client into the buffer
                    client.read(buffer);

                    // Prepare the buffer for reading by flipping it
                    buffer.flip();

                    // Convert the buffer's content to a string and print it
                    System.out.println(new String(buffer.array()).trim());

                    // Close the client connection after reading the data
                    client.close();
                }

                // Remove the processed key to avoid reprocessing it
                it.remove();
            }
        }
    }
}
```

b. NonBlockingClient.java
```java
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NonBlockingClient {
    public static void main(String[] args) throws IOException {
        // Define the server address (localhost on port 8080)
        InetSocketAddress address = new InetSocketAddress("localhost", 8080);

        // Open a SocketChannel and connect to the server
        SocketChannel client = SocketChannel.open(address);

        // Prepare the message to send to the server
        String message = "Hello from client";

        // Wrap the message bytes into a ByteBuffer for sending over the channel
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());

        // Write the message to the server through the channel
        client.write(buffer);

        // Clear the buffer after writing (optional, as we're closing the channel next)
        buffer.clear();

        // Close the client channel after sending the message
        client.close();
    }
}
```

---

# UNIT 10: UDP Programs

## Lab 1: UDP Client (Basic)

```java
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Create DatagramSocket (client side)
            DatagramSocket socket = new DatagramSocket();

            // Prepare message to send
            String message = "hello server";
            byte[] buffer = message.getBytes();

            // Create packet with message, server IP and port
            DatagramPacket packet = new DatagramPacket(
                buffer, buffer.length,
                InetAddress.getByName("127.0.0.1"), // Server address (localhost)
                4567                               // Server port
            );

            // Send message to server
            socket.send(packet);
            System.out.println("Message sent: " + message);

            // Prepare buffer to receive response
            packet = new DatagramPacket(new byte[1500], 1500);
            socket.receive(packet); // Receive reply from server

            // Convert received bytes to string
            message = new String(packet.getData()).trim();
            System.out.println("Message received: " + message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

**Sample Output (Client side):**

```
Message sent: hello server
Message received: hello client
```

---

## Lab 2: UDP Server (Basic)

```java
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Create DatagramSocket bound to port 4567
            DatagramSocket socket = new DatagramSocket(4567);
            System.out.println("Server is running...");

            // Buffer to store client message
            byte[] buffer = new byte[1500];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Wait for client message
            socket.receive(packet);
            String message = new String(packet.getData()).trim();
            System.out.println("Message received: " + message);

            // Prepare reply message
            InetAddress clientAddress = packet.getAddress();
            int clientPort = packet.getPort();
            message = "hello client";
            buffer = message.getBytes();

            // Send reply back to client
            packet = new DatagramPacket(buffer, buffer.length, clientAddress, clientPort);
            socket.send(packet);
            System.out.println("Message sent: " + message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

**Sample Output (Server side):**

```
Server is running...
Message received: hello server
Message sent: hello client
```

---

## Lab 3: UDP Client (Interactive with Scanner)

```java
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);
            String message;

            // Keep sending messages until user types 'exit'
            while (!(message = scanner.nextLine()).equalsIgnoreCase("exit")) {
                // Convert message into byte array
                byte[] buffer = message.getBytes();

                // Send packet to server
                DatagramPacket packet = new DatagramPacket(
                    buffer, buffer.length,
                    InetAddress.getByName("127.0.0.1"),
                    4567
                );
                socket.send(packet);
                System.out.println("Message sent: " + message);

                // Receive reply from server
                packet = new DatagramPacket(new byte[1500], 1500);
                socket.receive(packet);
                String reply = new String(packet.getData()).trim();
                System.out.println("Message received: " + reply);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

**Sample Output (Client side, interactive):**

```
hello
Message sent: hello
Message received: hello
how are you
Message sent: how are you
Message received: how are you
exit
```

---

## Lab 4: UDP Server (Echo Server with Loop)

```java
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(4567);
            System.out.println("Server is running...");

            while (true) {
                // Receive message from client
                byte[] buffer = new byte[1500];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String message = new String(packet.getData()).trim();
                System.out.println("Client: " + message);

                // Echo back the message
                InetAddress clientAddress = packet.getAddress();
                int clientPort = packet.getPort();
                buffer = message.getBytes();
                packet = new DatagramPacket(buffer, buffer.length, clientAddress, clientPort);
                socket.send(packet);
                System.out.println("Server: " + message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

**Sample Output (Server side, when multiple messages arrive):**

```
Server is running...
Client: hello
Server: hello
Client: how are you
Server: how are you
```

---

# UNIT 11: Multicasting

### Lab 1: Creating a Multicast Socket

```java
import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastExample {
    public static void main(String[] args) {
        try {
            // Create a MulticastSocket bound to port 4446
            MulticastSocket multicastSocket = new MulticastSocket(4446);
            System.out.println("Multicast Socket created on port 4446");

            // Join a multicast group at 230.0.0.0
            InetAddress group = InetAddress.getByName("230.0.0.0");
            multicastSocket.joinGroup(group);
            System.out.println("Joined multicast group: 230.0.0.0");

            // Leave the group and close
            multicastSocket.leaveGroup(group);
            multicastSocket.close();
            System.out.println("Left group and socket closed");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**Sample Output:**

```
Multicast Socket created on port 4446
Joined multicast group: 230.0.0.0
Left group and socket closed
```

---

### Lab 2: Sending Data to a Multicast Group

```java
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSender {
    public static void main(String[] args) {
        try {
            // Create multicast socket
            MulticastSocket socket = new MulticastSocket();

            // Multicast group
            InetAddress group = InetAddress.getByName("230.0.0.0");

            // Message to send
            String message = "Hello, multicast group!";
            byte[] buffer = message.getBytes();

            // Packet for multicast group at port 4446
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, 4446);

            // Send packet
            socket.send(packet);
            System.out.println("Message sent: " + message);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**Sample Output:**

```
Message sent: Hello, multicast group!
```

---

### Lab 3: Receiving Data from a Multicast Group

```java
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver {
    public static void main(String[] args) {
        try {
            // Create socket bound to port 4446
            MulticastSocket socket = new MulticastSocket(4446);

            // Join multicast group
            InetAddress group = InetAddress.getByName("230.0.0.0");
            socket.joinGroup(group);
            System.out.println("Joined multicast group: 230.0.0.0");

            // Prepare buffer for receiving
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Receive packet
            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received message: " + received);

            // Leave group
            socket.leaveGroup(group);
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**Sample Output (when sender is running):**

```
Joined multicast group: 230.0.0.0
Received message: Hello, multicast group!
```

---

# Unit 12: Remote Method Invocation (RMI)

## 12.1 Defining and Implementing RMI Service Interface

---

### Step 1: Define the RMI Service Interface

```java
import java.rmi.Remote;
import java.rmi.RemoteException;

// Remote interface must extend java.rmi.Remote
public interface Calculator extends Remote {
    // Each remote method must throw RemoteException
    int add(int a, int b) throws RemoteException;
    int subtract(int a, int b) throws RemoteException;
}
```

✅ **Explanation:**

* The `Calculator` interface extends `Remote`.
* Remote methods (`add`, `subtract`) must declare `throws RemoteException`.

---

### Step 2: Implement the RMI Service Interface

```java
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Implementation must extend UnicastRemoteObject
public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

    // Constructor must throw RemoteException
    protected CalculatorImpl() throws RemoteException {
        super();
    }

    // Implement add method
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    // Implement subtract method
    @Override
    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }
}
```

✅ **Explanation:**

* `CalculatorImpl` extends `UnicastRemoteObject` to make it a remote object.
* Methods provide actual implementations for remote calls.

---

### Step 3: Create the RMI Server

```java
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            // Create remote object
            CalculatorImpl calculator = new CalculatorImpl();

            // Start RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Bind the remote object with name "CalculatorService"
            Naming.rebind("rmi://localhost:1099/CalculatorService", calculator);

            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

✅ **Explanation:**

* RMI registry is started on port `1099`.
* Remote object is registered with name `CalculatorService`.

**Sample Output (Server side):**

```
RMI Server is running...
```

---

### Step 4: Create the RMI Client

```java
import java.rmi.Naming;

public class RMIClient {
    public static void main(String[] args) {
        try {
            // Look up the CalculatorService from RMI registry
            Calculator calculator = (Calculator) Naming.lookup("rmi://localhost:1099/CalculatorService");

            // Invoke remote methods
            int sum = calculator.add(5, 3);
            int difference = calculator.subtract(5, 3);

            // Print results
            System.out.println("Sum: " + sum);
            System.out.println("Difference: " + difference);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

✅ **Explanation:**

* Client connects to the RMI registry and looks up `CalculatorService`.
* Remote methods `add` and `subtract` are invoked like local methods.

**Sample Output (Client side):**

```
Sum: 8
Difference: 2
```

---

## 12.2 Creating an RMI Server and Client (Summary Flow)

1. **Remote Interface** (`Calculator.java`)
   Defines remote methods.
2. **Implementation** (`CalculatorImpl.java`)
   Provides actual method logic.
3. **Server** (`RMIServer.java`)
   Creates and binds remote object to RMI registry.
4. **Client** (`RMIClient.java`)
   Looks up remote object and calls its methods.

---

## 12.3 Running the RMI System

### Step 1: Compile Programs

```sh
javac Calculator.java CalculatorImpl.java RMIServer.java RMIClient.java
```

### Step 2: Start RMI Registry

```sh
rmiregistry
```

*(keep this terminal running)*

### Step 3: Run the RMI Server

```sh
java RMIServer
```

### Step 4: Run the RMI Client

```sh
java RMIClient
```

---


