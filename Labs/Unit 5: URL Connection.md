The `URLConnection` class in Java is used to establish a connection between the application and a URL resource. It allows retrieving data from web pages, such as content type, header fields, and input streams to read the page's content.

Note: Differences between URL and URLConnection.
- URLConnection provides access to the HTTP header.
- URLConnection can configure the request parameters sent to the server.
- URLConnection can write data to the server as well as read data from the server.

### **Example 1: Demonstrating `URLConnection` in Java**

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

### **Example 2: Downloading a Web Page Using `URLConnection` in Java**

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

```
<div style="max-height: 200px; overflow-y: scroll;">
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

<link rel="stylesheet" href="https://prime.edu.np/wp-content/themes/prime-college/assets/vendor/fancybox/jquery.fancybox.min.css">

    <!-- -----Custom Style----- -->
<link rel="stylesheet" href="https://prime.edu.np/wp-content/themes/prime-college/assets/css/style.css">
<link rel="stylesheet" href="https://prime.edu.np/wp-content/themes/prime-college/assets/css/responsive.css"/>

	<title>Home - Prime College</title>
	<style>img:is([sizes="auto" i], [sizes^="auto," i]) { contain-intrinsic-size: 3000px 1500px }</style>
	
		<!-- All in One SEO 4.7.8 - aioseo.com -->
	<meta name="robots" content="max-image-preview:large" />
	<link rel="canonical" href="https://prime.edu.np/" />
	<meta name="generator" content="All in One SEO (AIOSEO) 4.7.8" />
		<meta property="og:locale" content="en_US" />
		<meta property="og:site_name" content="Prime College -" />
		<meta property="og:type" content="website" />
		<meta property="og:title" content="Home - Prime College" />
		<meta property="og:url" content="https://prime.edu.np/" />
		<meta name="twitter:card" content="summary_large_image" />
		<meta name="twitter:title" content="Home - Prime College" />
		<script type="application/ld+json" class="aioseo-schema">
			{"@context":"https:\/\/schema.org","@graph":[{"@type":"BreadcrumbList","@id":"https:\/\/prime.edu.np\/#breadcrumblist","itemListElement":[{"@type":"ListItem","@id":"https:\/\/prime.edu.np\/#listItem","position":1,"name":"Home"}]},{"@type":"Organization","@id":"https:\/\/prime.edu.np\/#organization","name":"Prime College","url":"https:\/\/prime.edu.np\/"},{"@type":"WebPage","@id":"https:\/\/prime.edu.np\/#webpage","url":"https:\/\/prime.edu.np\/","name":"Home - Prime College","inLanguage":"en-US","isPartOf":{"@id":"https:\/\/prime.edu.np\/#website"},"breadcrumb":{"@id":"https:\/\/prime.edu.np\/#breadcrumblist"},"datePublished":"2023-07-25T10:06:00+05:45","dateModified":"2025-01-01T16:01:06+05:45"},{"@type":"WebSite","@id":"https:\/\/prime.edu.np\/#website","url":"https:\/\/prime.edu.np\/","name":"Prime College","inLanguage":"en-US","publisher":{"@id":"https:\/\/prime.edu.np\/#organization"},"potentialAction":{"@type":"SearchAction","target":{"@type":"EntryPoint","urlTemplate":"https:\/\/prime.edu.np\/?s={search_term_string}"},"query-input":"required name=search_term_string"}}]}
		</script>
		<!-- All in One SEO -->

<link rel='dns-prefetch' href='//use.fontawesome.com' />
<link rel="alternate" type="application/rss+xml" title="Prime College &raquo; Feed" href="https://prime.edu.np/feed/" />
<link rel="alternate" type="application/rss+xml" title="Prime College &raquo; Comments Feed" href="https://prime.edu.np/comments/feed/" />
<script>
window._wpemojiSettings = {"baseUrl":"https:\/\/s.w.org\/images\/core\/emoji\/15.0.3\/72x72\/","ext":".png","svgUrl":"https:\/\/s.w.org\/images\/core\/emoji\/15.0.3\/svg\/","svgExt":".svg","source":{"concatemoji":"https:\/\/prime.edu.np\/wp-includes\/js\/wp-emoji-release.min.js?ver=6.7.1"}};
/*! This file is auto-generated */
!function(i,n){var o,s,e;function c(e){try{var t={supportTests:e,timestamp:(new Date).valueOf()};sessionStorage.setItem(o,JSON.stringify(t))}catch(e){}}function p(e,t,n){e.clearRect(0,0,e.canvas.width,e.canvas.height),e.fillText(t,0,0);var t=new Uint32Array(e.getImageData(0,0,e.canvas.width,e.canvas.height).data),r=(e.clearRect(0,0,e.canvas.width,e.canvas.height),e.fillText(n,0,0),new Uint32Array(e.getImageData(0,0,e.canvas.width,e.canvas.height).data));return t.every(function(e,t){return e===r[t]})}function u(e,t,n){switch(t){case"flag":return n(e,"\ud83c\udff3\ufe0f\u200d\u26a7\ufe0f","\ud83c\udff3\ufe0f\u200b\u26a7\ufe0f")?!1:!n(e,"\ud83c\uddfa\ud83c\uddf3","\ud83c\uddfa\u200b\ud83c\uddf3")&&!n(e,"\ud83c\udff4\udb40\udc67\udb40\udc62\udb40\udc65\udb40\udc6e\udb40\udc67\udb40\udc7f","\ud83c\udff4\u200b\udb40\udc67\u200b\udb40\udc62\u200b\udb40\udc65\u200b\udb40\udc6e\u200b\udb40\udc67\u200b\udb40\udc7f");case"emoji":return!n(e,"\ud83d\udc26\u200d\u2b1b","\ud83d\udc26\u200b\u2b1b")}return!1}function f(e,t,n){var r="undefined"!=typeof WorkerGlobalScope&&self instanceof WorkerGlobalScope?new OffscreenCanvas(300,150):i.createElement("canvas"),a=r.getContext("2d",{willReadFrequently:!0}),o=(a.textBaseline="top",a.font="600 32px Arial",{});return e.forEach(function(e){o[e]=t(a,e,n)}),o}function t(e){var t=i.createElement("script");t.src=e,t.defer=!0,i.head.appendChild(t)}"undefined"!=typeof Promise&&(o="wpEmojiSettingsSupports",s=["flag","emoji"],n.supports={everything:!0,everythingExceptFlag:!0},e=new Promise(function(e){i.addEventListener("DOMContentLoaded",e,{once:!0})}),new Promise(function(t){var n=function(){try{var e=JSON.parse(sessionStorage.getItem(o));if("object"==typeof e&&"number"==typeof e.timestamp&&(new Date).valueOf()<e.timestamp+604800&&"object"==typeof e.supportTests)return e.supportTests}catch(e){}return null}();if(!n){if("undefined"!=typeof Worker&&"undefined"!=typeof OffscreenCanvas&&"undefined"!=typeof URL&&URL.createObjectURL&&"undefined"!=typeof Blob)try{var e="postMessage("+f.toString()+"("+[JSON.stringify(s),u.toString(),p.toString()].join(",")+"));",r=new Blob([e],{type:"text/javascript"}),a=new Worker(URL.createObjectURL(r),{name:"wpTestEmojiSupports"});return void(a.onmessage=function(e){c(n=e.data),a.terminate(),t(n)})}catch(e){}c(n=f(s,u,p))}t(n)}).then(function(e){for(var t in e)n.supports[t]=e[t],n.supports.everything=n.supports.everything&&n.supports[t],"flag"!==t&&(n.supports.everythingExceptFlag=n.supports.everythingExceptFlag&&n.supports[t]);n.supports.everythingExceptFlag=n.supports.everythingExceptFlag&&!n.supports.flag,n.DOMReady=!1,n.readyCallback=function(){n.DOMReady=!0}}).then(function(){return e}).then(function(){var e;n.supports.everything||(n.readyCallback(),(e=n.source||{}).concatemoji?t(e.concatemoji):e.wpemoji&&e.twemoji&&(t(e.twemoji),t(e.wpemoji)))}))}((window,document),window._wpemojiSettings);
</script>
<style id='wp-emoji-styles-inline-css'>

	img.wp-smiley, img.emoji {
		display: inline !important;
		border: none !important;
		box-shadow: none !important;
		height: 1em !important;
		width: 1em !important;
		margin: 0 0.07em !important;
		vertical-align: -0.1em !important;
		background: none !important;
		padding: 0 !important;
	}
</style>
<link rel='stylesheet' id='wp-block-library-css' href='https://prime.edu.np/wp-includes/css/dist/block-library/style.min.css?ver=6.7.1' media='all' />
<style id='classic-theme-styles-inline-css'>
/*! This file is auto-generated */
.wp-block-button__link{color:#fff;background-color:#32373c;border-radius:9999px;box-shadow:none;text-decoration:none;padding:calc(.667em + 2px) calc(1.333em + 2px);font-size:1.125em}.wp-block-file__button{background:#32373c;color:#fff;text-decoration:none}
</style>
<style id='global-styles-inline-css'>
:root{--wp--preset--aspect-ratio--square: 1;--wp--preset--aspect-ratio--4-3: 4/3;--wp--preset--aspect-ratio--3-4: 3/4;--wp--preset--aspect-ratio--3-2: 3/2;--wp--preset--aspect-ratio--2-3: 2/3;--wp--preset--aspect-ratio--16-9: 16/9;--wp--preset--aspect-ratio--9-16: 9/16;--wp--preset--color--black: #000000;--wp--preset--color--cyan-bluish-gray: #abb8c3;--wp--preset--color--white: #ffffff;--wp--preset--color--pale-pink: #f78da7;--wp--preset--color--vivid-red: #cf2e2e;--wp--preset--color--luminous-vivid-orange: #ff6900;--wp--preset--color--luminous-vivid-amber: #fcb900;--wp--preset--color--light-green-cyan: #7bdcb5;--wp--preset--color--vivid-green-cyan: #00d084;--wp--preset--color--pale-cyan-blue: #8ed1fc;--wp--preset--color--vivid-cyan-blue: #0693e3;--wp--preset--color--vivid-purple: #9b51e0;--wp--preset--gradient--vivid-cyan-blue-to-vivid-purple: linear-gradient(135deg,rgba(6,147,227,1) 0%,rgb(155,81,224) 100%);--wp--preset--gradient--light-green-cyan-to-vivid-green-cyan: linear-gradient(135deg,rgb(122,220,180) 0%,rgb(0,208,130) 100%);--wp--preset--gradient--luminous-vivid-amber-to-luminous-vivid-orange: linear-gradient(135deg,rgba(252,185,0,1) 0%,rgba(255,105,0,1) 100%);--wp--preset--gradient--luminous-vivid-orange-to-vivid-red: linear-gradient(135deg,rgba(255,105,0,1) 0%,rgb(207,46,46) 100%);--wp--preset--gradient--very-light-gray-to-cyan-bluish-gray: linear-gradient(135deg,rgb(238,238,238) 0%,rgb(169,184,195) 100%);--wp--preset--gradient--cool-to-warm-spectrum: linear-gradient(135deg,rgb(74,234,220) 0%,rgb(151,120,209) 20%,rgb(207,42,186) 40%,rgb(238,44,130) 60%,rgb(251,105,98) 80%,rgb(254,248,76) 100%);--wp--preset--gradient--blush-light-purple: linear-gradient(135deg,rgb(255,206,236) 0%,rgb(152,150,240) 100%);--wp--preset--gradient--blush-bordeaux: linear-gradient(135deg,rgb(254,205,165) 0%,rgb(254,45,45) 50%,rgb(107,0,62) 100%);--wp--preset--gradient--luminous-dusk: linear-gradient(135deg,rgb(255,203,112) 0%,rgb(199,81,192) 50%,rgb(65,88,208) 100%);--wp--preset--gradient--pale-ocean: linear-gradient(135deg,rgb(255,245,203) 0%,rgb(182,227,212) 50%,rgb(51,167,181) 100%);--wp--preset--gradient--electric-grass: linear-gradient(135deg,rgb(202,248,128) 0%,rgb(113,206,126) 100%);--wp--preset--gradient--midnight: linear-gradient(135deg,rgb(2,3,129) 0%,rgb(40,116,252) 100%);--wp--preset--font-size--small: 13px;--wp--preset--font-size--medium: 20px;--wp--preset--font-size--large: 36px;--wp--preset--font-size--x-large: 42px;--wp--preset--spacing--20: 0.44rem;--wp--preset--spacing--30: 0.67rem;--wp--preset--spacing--40: 1rem;--wp--preset--spacing--50: 1.5rem;--wp--preset--spacing--60: 2.25rem;--wp--preset--spacing--70: 3.38rem;--wp--preset--spacing--80: 5.06rem;--wp--preset--shadow--natural: 6px 6px 9px rgba(0, 0, 0, 0.2);--wp--preset--shadow--deep: 12px 12px 50px rgba(0, 0, 0, 0.4);--wp--preset--shadow--sharp: 6px 6px 0px rgba(0, 0, 0, 0.2);--wp--preset--shadow--outlined: 6px 6px 0px -3px rgba(255, 255, 255, 1), 6px 6px rgba(0, 0, 0, 1);--wp--preset--shadow--crisp: 6px 6px 0px rgba(0, 0, 0, 1);}:where(.is-layout-flex){gap: 0.5em;}:where(.is-layout-grid){gap: 0.5em;}body .is-layout-flex{display: flex;}.is-layout-flex{flex-wrap: wrap;align-items: center;}.is-layout-flex > :is(*, div){margin: 0;}body .is-layout-grid{display: grid;}.is-layout-grid > :is(*, div){margin: 0;}:where(.wp-block-columns.is-layout-flex){gap: 2em;}:where(.wp-block-columns.is-layout-grid){gap: 2em;}:where(.wp-block-post-template.is-layout-flex){gap: 1.25em;}:where(.wp-block-post-template.is-layout-grid){gap: 1.25em;}.has-black-color{color: var(--wp--preset--color--black) !important;}.has-cyan-bluish-gray-color{color: var(--wp--preset--color--cyan-bluish-gray) !important;}.has-white-color{color: var(--wp--preset--color--white) !important;}.has-pale-pink-color{color: var(--wp--preset--color--pale-pink) !important;}.has-vivid-red-color{color: var(--wp--preset--color--vivid-red) !important;}.has-luminous-vivid-orange-color{color: var(--wp--preset--color--luminous-vivid-orange) !important;}.has-luminous-vivid-amber-color{color: var(--wp--preset--color--luminous-vivid-amber) !important;}.has-light-green-cyan-color{color: var(--wp--preset--color--light-green-cyan) !important;}.has-vivid-green-cyan-color{color: var(--wp--preset--color--vivid-green-cyan) !important;}.has-pale-cyan-blue-color{color: var(--wp--preset--color--pale-cyan-blue) !important;}.has-vivid-cyan-blue-color{color: var(--wp--preset--color--vivid-cyan-blue) !important;}.has-vivid-purple-color{color: var(--wp--preset--color--vivid-purple) !important;}.has-black-background-color{background-color: var(--wp--preset--color--black) !important;}.has-cyan-bluish-gray-background-color{background-color: var(--wp--preset--color--cyan-bluish-gray) !important;}.has-white-background-color{background-color: var(--wp--preset--color--white) !important;}.has-pale-pink-background-color{background-color: var(--wp--preset--color--pale-pink) !important;}.has-vivid-red-background-color{background-color: var(--wp--preset--color--vivid-red) !important;}.has-luminous-vivid-orange-background-color{background-color: var(--wp--preset--color--luminous-vivid-orange) !important;}.has-luminous-vivid-amber-background-color{background-color: var(--wp--preset--color--luminous-vivid-amber) !important;}.has-light-green-cyan-background-color{background-color: var(--wp--preset--color--light-green-cyan) !important;}.has-vivid-green-cyan-background-color{background-color: var(--wp--preset--color--vivid-green-cyan) !important;}.has-pale-cyan-blue-background-color{background-color: var(--wp--preset--color--pale-cyan-blue) !important;}.has-vivid-cyan-blue-background-color{background-color: var(--wp--preset--color--vivid-cyan-blue) !important;}.has-vivid-purple-background-color{background-color: var(--wp--preset--color--vivid-purple) !important;}.has-black-border-color{border-color: var(--wp--preset--color--black) !important;}.has-cyan-bluish-gray-border-color{border-color: var(--wp--preset--color--cyan-bluish-gray) !important;}.has-white-border-color{border-color: var(--wp--preset--color--white) !important;}.has-pale-pink-border-color{border-color: var(--wp--preset--color--pale-pink) !important;}.has-vivid-red-border-color{border-color: var(--wp--preset--color--vivid-red) !important;}.has-luminous-vivid-orange-border-color{border-color: var(--wp--preset--color--luminous-vivid-orange) !important;}.has-luminous-vivid-amber-border-color{border-color: var(--wp--preset--color--luminous-vivid-amber) !important;}.has-light-green-cyan-border-color{border-color: var(--wp--preset--color--light-green-cyan) !important;}.has-vivid-green-cyan-border-color{border-color: var(--wp--preset--color--vivid-green-cyan) !important;}.has-pale-cyan-blue-border-color{border-color: var(--wp--preset--color--pale-cyan-blue) !important;}.has-vivid-cyan-blue-border-color{border-color: var(--wp--preset--color--vivid-cyan-blue) !important;}.has-vivid-purple-border-color{border-color: var(--wp--preset--color--vivid-purple) !important;}.has-vivid-cyan-blue-to-vivid-purple-gradient-background{background: var(--wp--preset--gradient--vivid-cyan-blue-to-vivid-purple) !important;}.has-light-green-cyan-to-vivid-green-cyan-gradient-background{background: var(--wp--preset--gradient--light-green-cyan-to-vivid-green-cyan) !important;}.has-luminous-vivid-amber-to-luminous-vivid-orange-gradient-background{background: var(--wp--preset--gradient--luminous-vivid-amber-to-luminous-vivid-orange) !important;}.has-luminous-vivid-orange-to-vivid-red-gradient-background{background: var(--wp--preset--gradient--luminous-vivid-orange-to-vivid-red) !important;}.has-very-light-gray-to-cyan-bluish-gray-gradient-background{background: var(--wp--preset--gradient--very-light-gray-to-cyan-bluish-gray) !important;}.has-cool-to-warm-spectrum-gradient-background{background: var(--wp--preset--gradient--cool-to-warm-spectrum) !important;}.has-blush-light-purple-gradient-background{background: var(--wp--preset--gradient--blush-light-purple) !important;}.has-blush-bordeaux-gradient-background{background: var(--wp--preset--gradient--blush-bordeaux) !important;}.has-luminous-dusk-gradient-background{background: var(--wp--preset--gradient--luminous-dusk) !important;}.has-pale-ocean-gradient-background{background: var(--wp--preset--gradient--pale-ocean) !important;}.has-electric-grass-gradient-background{background: var(--wp--preset--gradient--electric-grass) !important;}.has-midnight-gradient-background{background: var(--wp--preset--gradient--midnight) !important;}.has-small-font-size{font-size: var(--wp--preset--font-size--small) !important;}.has-medium-font-size{font-size: var(--wp--preset--font-size--medium) !important;}.has-large-font-size{font-size: var(--wp--preset--font-size--large) !important;}.has-x-large-font-size{font-size: var(--wp--preset--font-size--x-large) !important;}
:where(.wp-block-post-template.is-layout-flex){gap: 1.25em;}:where(.wp-block-post-template.is-layout-grid){gap: 1.25em;}
:where(.wp-block-columns.is-layout-flex){gap: 2em;}:where(.wp-block-columns.is-layout-grid){gap: 2em;}
:root :where(.wp-block-pullquote){font-size: 1.5em;line-height: 1.6;}
</style>
<link rel='stylesheet' id='contact-form-7-css' href='https://prime.edu.np/wp-content/plugins/contact-form-7/includes/css/styles.css?ver=6.0.3' media='all' />
<style id='contact-form-7-inline-css'>
.wpcf7 .wpcf7-recaptcha iframe {margin-bottom: 0;}.wpcf7 .wpcf7-recaptcha[data-align="center"] > div {margin: 0 auto;}.wpcf7 .wpcf7-recaptcha[data-align="right"] > div {margin: 0 0 0 auto;}
</style>
<link rel='stylesheet' id='wpsr_main_css-css' href='https://prime.edu.np/wp-content/plugins/wp-socializer/public/css/wpsr.min.css?ver=7.9' media='all' />
<link rel='stylesheet' id='wpsr_fa_icons-css' href='https://use.fontawesome.com/releases/v6.7.2/css/all.css?ver=7.9' media='all' />
<link rel='stylesheet' id='prime-college-style-css' href='https://prime.edu.np/wp-content/themes/prime-college/style.css?ver=1.0.0' media='all' />
<link rel='stylesheet' id='popup-maker-site-css' href='https://prime.edu.np/wp-content/plugins/popup-maker/assets/css/pum-site.min.css?ver=1.20.3' media='all' />
<style id='popup-maker-site-inline-css'>
/* Popup Google Fonts */
@import url('//fonts.googleapis.com/css?family=Montserrat:100');

/* Popup Theme 2307: Default Theme */
.pum-theme-2307, .pum-theme-default-theme { background-color: rgba( 255, 255, 255, 1.00 ) } 
.pum-theme-2307 .pum-container, .pum-theme-default-theme .pum-container { padding: 18px; border-radius: 0px; border: 1px none #000000; box-shadow: 1px 1px 3px 0px rgba( 2, 2, 2, 0.23 ); background-color: rgba( 249, 249, 249, 1.00 ) } 
.pum-theme-2307 .pum-title, .pum-theme-default-theme .pum-title { color: #000000; text-align: left; text-shadow: 0px 0px 0px rgba( 2, 2, 2, 0.23 ); font-family: inherit; font-weight: 400; font-size: 32px; font-style: normal; line-height: 36px } 
.pum-theme-2307 .pum-content, .pum-theme-default-theme .pum-content { color: #8c8c8c; font-family: inherit; font-weight: 400; font-style: inherit } 
.pum-theme-2307 .pum-content + .pum-close, .pum-theme-default-theme .pum-content + .pum-close { position: absolute; height: auto; width: auto; left: auto; right: 0px; bottom: auto; top: 0px; padding: 8px; color: #ffffff; font-family: inherit; font-weight: 400; font-size: 12px; font-style: inherit; line-height: 36px; border: 1px none #ffffff; border-radius: 0px; box-shadow: 1px 1px 3px 0px rgba( 2, 2, 2, 0.23 ); text-shadow: 0px 0px 0px rgba( 0, 0, 0, 0.23 ); background-color: rgba( 0, 183, 205, 1.00 ) } 

/* Popup Theme 2308: Light Box */
.pum-theme-2308, .pum-theme-lightbox { background-color: rgba( 0, 0, 0, 0.60 ) } 
.pum-theme-2308 .pum-container, .pum-theme-lightbox .pum-container { padding: 18px; border-radius: 3px; border: 8px solid #000000; box-shadow: 0px 0px 30px 0px rgba( 2, 2, 2, 1.00 ); background-color: rgba( 255, 255, 255, 1.00 ) } 
.pum-theme-2308 .pum-title, .pum-theme-lightbox .pum-title { color: #000000; text-align: left; text-shadow: 0px 0px 0px rgba( 2, 2, 2, 0.23 ); font-family: inherit; font-weight: 100; font-size: 32px; line-height: 36px } 
.pum-theme-2308 .pum-content, .pum-theme-lightbox .pum-content { color: #000000; font-family: inherit; font-weight: 100 } 
.pum-theme-2308 .pum-content + .pum-close, .pum-theme-lightbox .pum-content + .pum-close { position: absolute; height: 26px; width: 26px; left: auto; right: -13px; bottom: auto; top: -13px; padding: 0px; color: #ffffff; font-family: Arial; font-weight: 100; font-size: 24px; line-height: 24px; border: 2px solid #ffffff; border-radius: 26px; box-shadow: 0px 0px 15px 1px rgba( 2, 2, 2, 0.75 ); text-shadow: 0px 0px 0px rgba( 0, 0, 0, 0.23 ); background-color: rgba( 0, 0, 0, 1.00 ) } 

/* Popup Theme 2309: Enterprise Blue */
.pum-theme-2309, .pum-theme-enterprise-blue { background-color: rgba( 0, 0, 0, 0.70 ) } 
.pum-theme-2309 .pum-container, .pum-theme-enterprise-blue .pum-container { padding: 28px; border-radius: 5px; border: 1px none #000000; box-shadow: 0px 10px 25px 4px rgba( 2, 2, 2, 0.50 ); background-color: rgba( 255, 255, 255, 1.00 ) } 
.pum-theme-2309 .pum-title, .pum-theme-enterprise-blue .pum-title { color: #315b7c; text-align: left; text-shadow: 0px 0px 0px rgba( 2, 2, 2, 0.23 ); font-family: inherit; font-weight: 100; font-size: 34px; line-height: 36px } 
.pum-theme-2309 .pum-content, .pum-theme-enterprise-blue .pum-content { color: #2d2d2d; font-family: inherit; font-weight: 100 } 
.pum-theme-2309 .pum-content + .pum-close, .pum-theme-enterprise-blue .pum-content + .pum-close { position: absolute; height: 28px; width: 28px; left: auto; right: 8px; bottom: auto; top: 8px; padding: 4px; color: #ffffff; font-family: Times New Roman; font-weight: 100; font-size: 20px; line-height: 20px; border: 1px none #ffffff; border-radius: 42px; box-shadow: 0px 0px 0px 0px rgba( 2, 2, 2, 0.23 ); text-shadow: 0px 0px 0px rgba( 0, 0, 0, 0.23 ); background-color: rgba( 49, 91, 124, 1.00 ) } 

/* Popup Theme 2310: Hello Box */
.pum-theme-2310, .pum-theme-hello-box { background-color: rgba( 0, 0, 0, 0.75 ) } 
.pum-theme-2310 .pum-container, .pum-theme-hello-box .pum-container { padding: 30px; border-radius: 80px; border: 14px solid #81d742; box-shadow: 0px 0px 0px 0px rgba( 2, 2, 2, 0.00 ); background-color: rgba( 255, 255, 255, 1.00 ) } 
.pum-theme-2310 .pum-title, .pum-theme-hello-box .pum-title { color: #2d2d2d; text-align: left; text-shadow: 0px 0px 0px rgba( 2, 2, 2, 0.23 ); font-family: Montserrat; font-weight: 100; font-size: 32px; line-height: 36px } 
.pum-theme-2310 .pum-content, .pum-theme-hello-box .pum-content { color: #2d2d2d; font-family: inherit; font-weight: 100 } 
.pum-theme-2310 .pum-content + .pum-close, .pum-theme-hello-box .pum-content + .pum-close { position: absolute; height: auto; width: auto; left: auto; right: -30px; bottom: auto; top: -30px; padding: 0px; color: #2d2d2d; font-family: Times New Roman; font-weight: 100; font-size: 32px; line-height: 28px; border: 1px none #ffffff; border-radius: 28px; box-shadow: 0px 0px 0px 0px rgba( 2, 2, 2, 0.23 ); text-shadow: 0px 0px 0px rgba( 0, 0, 0, 0.23 ); background-color: rgba( 255, 255, 255, 1.00 ) } 

/* Popup Theme 2311: Cutting Edge */
.pum-theme-2311, .pum-theme-cutting-edge { background-color: rgba( 0, 0, 0, 0.50 ) } 
.pum-theme-2311 .pum-container, .pum-theme-cutting-edge .pum-container { padding: 18px; border-radius: 0px; border: 1px none #000000; box-shadow: 0px 10px 25px 0px rgba( 2, 2, 2, 0.50 ); background-color: rgba( 30, 115, 190, 1.00 ) } 
.pum-theme-2311 .pum-title, .pum-theme-cutting-edge .pum-title { color: #ffffff; text-align: left; text-shadow: 0px 0px 0px rgba( 2, 2, 2, 0.23 ); font-family: Sans-Serif; font-weight: 100; font-size: 26px; line-height: 28px } 
.pum-theme-2311 .pum-content, .pum-theme-cutting-edge .pum-content { color: #ffffff; font-family: inherit; font-weight: 100 } 
.pum-theme-2311 .pum-content + .pum-close, .pum-theme-cutting-edge .pum-content + .pum-close { position: absolute; height: 24px; width: 24px; left: auto; right: 0px; bottom: auto; top: 0px; padding: 0px; color: #1e73be; font-family: Times New Roman; font-weight: 100; font-size: 32px; line-height: 24px; border: 1px none #ffffff; border-radius: 0px; box-shadow: -1px 1px 1px 0px rgba( 2, 2, 2, 0.10 ); text-shadow: -1px 1px 1px rgba( 0, 0, 0, 0.10 ); background-color: rgba( 238, 238, 34, 1.00 ) } 

/* Popup Theme 2312: Framed Border */
.pum-theme-2312, .pum-theme-framed-border { background-color: rgba( 255, 255, 255, 0.50 ) } 
.pum-theme-2312 .pum-container, .pum-theme-framed-border .pum-container { padding: 18px; border-radius: 0px; border: 20px outset #dd3333; box-shadow: 1px 1px 3px 0px rgba( 2, 2, 2, 0.97 ) inset; background-color: rgba( 255, 251, 239, 1.00 ) } 
.pum-theme-2312 .pum-title, .pum-theme-framed-border .pum-title { color: #000000; text-align: left; text-shadow: 0px 0px 0px rgba( 2, 2, 2, 0.23 ); font-family: inherit; font-weight: 100; font-size: 32px; line-height: 36px } 
.pum-theme-2312 .pum-content, .pum-theme-framed-border .pum-content { color: #2d2d2d; font-family: inherit; font-weight: 100 } 
.pum-theme-2312 .pum-content + .pum-close, .pum-theme-framed-border .pum-content + .pum-close { position: absolute; height: 20px; width: 20px; left: auto; right: -20px; bottom: auto; top: -20px; padding: 0px; color: #ffffff; font-family: Tahoma; font-weight: 700; font-size: 16px; line-height: 18px; border: 1px none #ffffff; border-radius: 0px; box-shadow: 0px 0px 0px 0px rgba( 2, 2, 2, 0.23 ); text-shadow: 0px 0px 0px rgba( 0, 0, 0, 0.23 ); background-color: rgba( 0, 0, 0, 0.55 ) } 

/* Popup Theme 2313: Floating Bar - Soft Blue */
.pum-theme-2313, .pum-theme-floating-bar { background-color: rgba( 255, 255, 255, 0.00 ) } 
.pum-theme-2313 .pum-container, .pum-theme-floating-bar .pum-container { padding: 8px; border-radius: 0px; border: 1px none #000000; box-shadow: 1px 1px 3px 0px rgba( 2, 2, 2, 0.23 ); background-color: rgba( 238, 246, 252, 1.00 ) } 
.pum-theme-2313 .pum-title, .pum-theme-floating-bar .pum-title { color: #505050; text-align: left; text-shadow: 0px 0px 0px rgba( 2, 2, 2, 0.23 ); font-family: inherit; font-weight: 400; font-size: 32px; line-height: 36px } 
.pum-theme-2313 .pum-content, .pum-theme-floating-bar .pum-content { color: #505050; font-family: inherit; font-weight: 400 } 
.pum-theme-2313 .pum-content + .pum-close, .pum-theme-floating-bar .pum-content + .pum-close { position: absolute; height: 18px; width: 18px; left: auto; right: 5px; bottom: auto; top: 50%; padding: 0px; color: #505050; font-family: Sans-Serif; font-weight: 700; font-size: 15px; line-height: 18px; border: 1px solid #505050; border-radius: 15px; box-shadow: 0px 0px 0px 0px rgba( 2, 2, 2, 0.00 ); text-shadow: 0px 0px 0px rgba( 0, 0, 0, 0.00 ); background-color: rgba( 255, 255, 255, 0.00 ); transform: translate(0, -50%) } 

/* Popup Theme 2314: Content Only - For use with page builders or block editor */
.pum-theme-2314, .pum-theme-content-only { background-color: rgba( 0, 0, 0, 0.70 ) } 
.pum-theme-2314 .pum-container, .pum-theme-content-only .pum-container { padding: 0px; border-radius: 0px; border: 1px none #000000; box-shadow: 0px 0px 0px 0px rgba( 2, 2, 2, 0.00 ) } 
.pum-theme-2314 .pum-title, .pum-theme-content-only .pum-title { color: #000000; text-align: left; text-shadow: 0px 0px 0px rgba( 2, 2, 2, 0.23 ); font-family: inherit; font-weight: 400; font-size: 32px; line-height: 36px } 
.pum-theme-2314 .pum-content, .pum-theme-content-only .pum-content { color: #8c8c8c; font-family: inherit; font-weight: 400 } 
.pum-theme-2314 .pum-content + .pum-close, .pum-theme-content-only .pum-content + .pum-close { position: absolute; height: 18px; width: 18px; left: auto; right: 7px; bottom: auto; top: 7px; padding: 0px; color: #000000; font-family: inherit; font-weight: 700; font-size: 20px; line-height: 20px; border: 1px none #ffffff; border-radius: 15px; box-shadow: 0px 0px 0px 0px rgba( 2, 2, 2, 0.00 ); text-shadow: 0px 0px 0px rgba( 0, 0, 0, 0.00 ); background-color: rgba( 255, 255, 255, 0.00 ) } 

#pum-2316 {z-index: 1999999999}
#pum-2455 {z-index: 1999999999}
#pum-2315 {z-index: 1999999999}

</style>
<script src="https://prime.edu.np/wp-includes/js/jquery/jquery.min.js?ver=3.7.1" id="jquery-core-js"></script>
<script src="https://prime.edu.np/wp-includes/js/jquery/jquery-migrate.min.js?ver=3.4.1" id="jquery-migrate-js"></script>
<link rel="https://api.w.org/" href="https://prime.edu.np/wp-json/" /><link rel="alternate" title="JSON" type="application/json" href="https://prime.edu.np/wp-json/wp/v2/pages/7" /><link rel="EditURI" type="application/rsd+xml" title="RSD" href="https://prime.edu.np/xmlrpc.php?rsd" />
<meta name="generator" content="WordPress 6.7.1" />
<link rel='shortlink' href='https://prime.edu.np/' />
<link rel="alternate" title="oEmbed (JSON)" type="application/json+oembed" href="https://prime.edu.np/wp-json/oembed/1.0/embed?url=https%3A%2F%2Fprime.edu.np%2F" />
<link rel="alternate" title="oEmbed (XML)" type="text/xml+oembed" href="https://prime.edu.np/wp-json/oembed/1.0/embed?url=https%3A%2F%2Fprime.edu.np%2F&#038;format=xml" />
		<style id="wp-custom-css">
			header.fixed-header {

z-index:9999;
}


.sc-1au8ryl-0.dmopMx {
    display: none;
}
.sc-sbsi7l-0.cLcbjv{
	display:none;
}



/* ---Media Query---- */
@media (max-width: 767.98px) {
	.club-item.seven{
		padding-bottom:40px;
	}
}

.justified-text {
    text-align: justify;
}		</style>
			
	<!-- Google tag (gtag.js) -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G- E340X0X4Q2"></script>
<!--<script src="https://prime.edu.np/wp-content/themes/prime-college/assets/js/jquery-3.7.0.min.js"></script>-->
<script>
window.dataLayer = window.dataLayer || []; function gtag(){dataLayer.push(arguments);} gtag('js', new Date());

gtag('config', 'G-E340X0X4Q2');
</script>

</head>

<body class="home page-template-default page page-id-7">
   <!-- Start Top Header -->
<div class="top-header">
  <div class="container-fluid">
    <div class="row">
      <div class="col-12 col-sm-9 col-md-8">
        <ul>
          <li><span class="icon"><i class="fa-solid fa-phone"></i></span><a href="tel:01-4961690">01-4961690</a> | <a href="tel:01-4970072">01-4970072</a></li>
          <li><span class="icon"><i class="fa-solid fa-envelope"></i></span><a href="/cdn-cgi/l/email-protection#deb7b0b8b19eaeacb7b3bbf0bbbaabf0b0ae"><span class="__cf_email__" data-cfemail="dcb5b2bab39cacaeb5b1b9f2b9b8a9f2b2ac">[email&#160;protected]</span></a></li>
        </ul>
      </div>
      <div class="col-sm-3 col-md-4 d-none d-sm-block">
        <ul class="si-wrap text-end">
        <li><a href="https://www.facebook.com/primecollegenp" target="_blank"><i class="fa-brands fa-facebook-f"></i></a></li>
          <li><a href="https://www.youtube.com/user/primecollege1" target="_blank"><i class="fa-brands fa-youtube"></i></a></li>
          <li><a href="https://www.instagram.com/prime__college/?hl=en" target="_blank"><i class="fa-brands fa-instagram"></i></a></li>
          <li><a href="https://np.linkedin.com/company/prime-college-nepal" target="_blank"><i class="fa-brands fa-linkedin-in"></i></a></li>
          <li><a href="https://www.tiktok.com/@prime_college" target="_blank"><i class="fa-brands fa-tiktok"></i></a></li>
        </ul>
      </div>
    </div>
  </div>
</div>
<!-- End Top Header -->

<!-- Start Header -->
<header>
  <nav class="navbar navbar-expand-lg navbar-dark" aria-label="Fourth navbar example">
    <div class="container-fluid">
      <a class="navbar-brand" href="https://prime.edu.np"><img src="https://prime.edu.np/wp-content/uploads/2023/08/prime-logo.svg" alt="logo"></a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
      <i class="fa-solid fa-bars-staggered"></i>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExample04">
          <ul id="menu-primary-menu" class="navbar-nav ms-auto mb-2 mb-md-0"><li id="menu-item-487" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-487"><a href="https://prime.edu.np/about/">Who We Are</a></li>
<li id="menu-item-488" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-488"><a href="https://prime.edu.np/programs/">Our Programs</a></li>
<li id="menu-item-489" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-489"><a href="https://prime.edu.np/why-join-prime/">Why Join Prime</a></li>
<li id="menu-item-1443" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1443"><a href="https://prime.edu.np/life-at-prime/">Life at Prime</a></li>
<li id="menu-item-491" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-491"><a href="https://prime.edu.np/contact-us/">Contact Us</a></li>
<li id="menu-item-492" class="btn btn-primary menu-item menu-item-type-post_type menu-item-object-page menu-item-492"><a href="https://prime.edu.np/apply-now/">Apply Now</a></li>
</ul>      
      </div>
      <div class="bar-wrap">
          <a href="#" class="bar"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/bars.svg" alt="bar" class="bar-icon"></a>
          <div class="mega-menu-wrap">
  <!--<div class="mega-close">-->
  <!--<i class="fa-solid fa-xmark"></i>-->
  <!--</div>-->
  <div class="mega-menu-inner">
  <div class="container">
    <div class="row">
      <div class="col-sm-6 col-md-4 col-lg-3">
        <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/about">Who We Are?</a></h4>
          <ul id="menu-who-we-are" class="menu"><li id="menu-item-517" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-517"><a href="https://prime.edu.np/about/">About Us</a></li>
<li id="menu-item-518" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-518"><a href="https://prime.edu.np/team/">Know Our Team</a></li>
</ul>        </div>
        <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/programs">Our Programs</a></h4>
        <ul id="menu-our-programs" class="menu"><li id="menu-item-529" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-529"><a href="https://prime.edu.np/program/bim/">BIM</a></li>
<li id="menu-item-524" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-524"><a href="https://prime.edu.np/program/bachelor-of-business-administration/">BBA</a></li>
<li id="menu-item-525" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-525"><a href="https://prime.edu.np/program/bachelor-of-business-studies/">BBS</a></li>
<li id="menu-item-527" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-527"><a href="https://prime.edu.np/program/bachelors-of-science-in-csit/">BSc. CSIT</a></li>
<li id="menu-item-528" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-528"><a href="https://prime.edu.np/program/bbm/">BBM</a></li>
<li id="menu-item-526" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-526"><a href="https://prime.edu.np/program/bachelor-of-computer-applications/">BCA</a></li>
<li id="menu-item-530" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-530"><a href="https://prime.edu.np/program/mbs/">MBS</a></li>
</ul>        </div>
        <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/life-at-prime/">Life at Prime</a></h4>
         <ul id="menu-life-at-prime" class="menu"><li id="menu-item-544" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-544"><a href="https://prime.edu.np/events/">News and Events</a></li>
<li id="menu-item-1438" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1438"><a href="https://prime.edu.np/prime-blog/">Prime Blogs</a></li>
<li id="menu-item-2516" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-2516"><a href="https://prime.edu.np/prime-innovators-hub/">Prime Innovators Hub</a></li>
<li id="menu-item-758" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-758"><a href="https://prime.edu.np/prime-in-picture/">Prime In Pictures</a></li>
</ul>        </div>

        
      </div>
      <div class="col-sm-6 col-md-4 col-lg-3">
        <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/why-join-prime/">Why Join Prime ?</a></h4>
          <ul id="menu-why-join-prime" class="menu"><li id="menu-item-672" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-672"><a href="https://prime.edu.np/infrastructure/">Progressive Infrastructure</a></li>
<li id="menu-item-736" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-736"><a href="https://prime.edu.np/pride-of-prime/">Pride Of Prime</a></li>
<li id="menu-item-1199" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1199"><a href="https://prime.edu.np/what-makes-prime-special/">What Makes Prime Special</a></li>
<li id="menu-item-1291" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1291"><a href="https://prime.edu.np/read-our-story/">Read Our Story</a></li>
</ul>        </div>
		    <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/mlrc/">Mathema Learning Resource Center(MLRC)</a></h4>
          <ul id="menu-mathema-learning-resource-center-mlrc" class="menu"><li id="menu-item-950" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-950"><a href="https://prime.edu.np/mlrc/">Value Added Course</a></li>
<li id="menu-item-949" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-949"><a href="https://prime.edu.np/mlrc/">Student Support Division</a></li>
<li id="menu-item-1200" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1200"><a href="https://prime.edu.np/student-club/">Student’s Club</a></li>
</ul>        </div>
		     <div class="mega-menu-item">
		   <h4><a href="#">Prime Alumni Association</a></h4>
          <ul id="menu-prime-alumni-association" class="menu"><li id="menu-item-650" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-650"><a href="#">Form</a></li>
<li id="menu-item-651" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-651"><a href="#">Our Alumni</a></li>
</ul>        </div>
        
      </div>
      <div class="col-sm-6 col-md-4 col-lg-3">
		  <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/career/">Prime Career Center</a></h4>
          <ul id="menu-prime-career-center" class="menu"><li id="menu-item-1254" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1254"><a href="https://prime.edu.np/career/">Student Internship Program</a></li>
<li id="menu-item-1255" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1255"><a href="https://prime.edu.np/career/">Career Building Program</a></li>
<li id="menu-item-1256" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1256"><a href="https://prime.edu.np/prime-career-partners/">Prime Career Center Partners</a></li>
</ul>        </div>
<div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/eso/">Ethics and Standard Office</a></h4>
          <ul id="menu-ethics-and-standard-office" class="menu"><li id="menu-item-969" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-969"><a href="https://prime.edu.np/eso/">Prime Wellness Center</a></li>
</ul>        </div>
        
       
         
       
        <div class="mega-menu-item">
          <h4><a href="#">Our Partners</a></h4>
         <ul id="menu-our-partners" class="menu"><li id="menu-item-606" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-606"><a href="https://prime.edu.np/prime-career-partners/">Prime Career Partners</a></li>
<li id="menu-item-605" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-605"><a href="https://prime.edu.np/world-wide-partners/">World Wide Partners</a></li>
<li id="menu-item-604" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-604"><a href="https://prime.edu.np/prime-privilege-partners/">Prime Privilege Partners</a></li>
</ul>        </div>
         <div class="mega-menu-item">
          <h4><a href="#">Hall Booking</a></h4>
           <ul id="menu-seminar-hall-booking" class="menu"><li id="menu-item-2224" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-2224"><a href="https://prime.edu.np/hall-booking/">Seminar Hall Booking</a></li>
<li id="menu-item-2223" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-2223"><a href="https://prime.edu.np/room-booking/">Multipurpose Room Booking</a></li>
</ul>        </div>
        
     
      </div>
      <div class="col-sm-6 col-md-4 col-lg-3">

                        <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/vacancy/">Join Our Team</a></h4>
          
        </div>
        
                                <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/notices/">College Notices</a></h4>
          
        </div>
                		   

                <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/faq/">FAQ </a></h4>
          
        </div>
		  <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/character-certificate-form/">Character Certificate Form</a></h4>
          
        </div>
        <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/new-id-card-issuance/">New ID Card Issuance Form</a></h4>
          
        </div>
        <div class="mega-menu-item">
          <h4><a href="https://prime.paathshala.com.np/Login.aspx" target="_blank">Prime Online Portal Login</a></h4>
          
        </div>
        <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/contact-us/">Contact us </a></h4>
          
        </div>
   
         <div class="mega-menu-item">
          <h4><a href="https://forms.office.com/r/q7Sv1Hc4mw" target="_blank">Event Registration Form</a></h4>
          
        </div>  <div class="mega-menu-item">
          <h4><a href="https://forms.office.com/r/rvefAsv5QQ" target="_blank">Tour and Travel Form</a></h4>
          
        </div>
       
      </div>
      </div>
  </div>
  </div>
  <div class="apply-cta-wrap">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-10 col-lg-8">
          <div class="d-md-flex align-items-center justify-content-between">
            <div class="mb-4 mb-md-0">
              <h4 class="mb-1">Apply Now</h4>
              <small>Would you like to apply for the admission session?</small>
            </div>
            <div>
              <a href="https://prime.edu.np/apply-now" class="btn btn-outline-light d-block d-sm-inline-block">Apply</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
      </div>
      
      <a href="#" class="search-trigger"><i class="fa-solid fa-magnifying-glass"></i></a>
<!--      <form class="search-bar-wrapper">-->
<!--          <div class="search-bar-inner">-->
<!--  <div class="input-wrapper">-->
<!--    <input type="text" placeholder="Search Here..." class="input-field">-->
<!--    <button type="submit" class="search-icon">-->
<!--      <img src="https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/search-1024.png" width="26" height="26" alt="search -->
<!--                bar">-->
<!--    </button>-->
<!--  </div>-->
<!--  </div>-->
<!--</form>-->
    </div>
  </nav>
</header>
<!-- End Header -->

<div class="search-box-wrap">
    <form>
        <input type="text"  value="" name="s" id="s" placeholder="Search here...." class="form-control" autofocus="">
    </form>
</div>

<!-- ----------Mega Menu--------- -->

<!-- Start Banner Section -->
<div class="banner-section">
  <!-- Slider main container -->
  <div class="swiper banner-slider">
    <!-- Additional required wrapper -->
    <div class="swiper-wrapper">
      <!-- Slides -->
             <div class="swiper-slide" style="background-image: url('https://prime.edu.np/wp-content/uploads/2023/08/1.-Initiate-scaled.jpg');">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <div class="banner-content-wrap">
                <div class="banner-content">
                  <h1 class="line-1 anim-typewriter">Initiate...</h1>
                  <!-- <p>Prime College is the first IT enabled college of Nepal</p> -->
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
            <div class="swiper-slide" style="background-image: url('https://prime.edu.np/wp-content/uploads/2023/08/2.-Explore-scaled.jpg');">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <div class="banner-content-wrap">
                <div class="banner-content">
                  <h1 class="line-1 anim-typewriter">Explore...</h1>
                  <!-- <p>Prime College is the first IT enabled college of Nepal</p> -->
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
            <div class="swiper-slide" style="background-image: url('https://prime.edu.np/wp-content/uploads/2023/08/3.-Innovate-scaled.jpg');">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <div class="banner-content-wrap">
                <div class="banner-content">
                  <h1 class="line-1 anim-typewriter">Innovate...</h1>
                  <!-- <p>Prime College is the first IT enabled college of Nepal</p> -->
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
       
    </div>

    <!-- If we need navigation buttons -->
    <div class="swiper-button-prev"></div>
    <div class="swiper-button-next"></div>

  </div>
</div>
<!-- End Banner Section -->
<!-- Start Prime Experience Center -->
<div class="prime-experience-section block pb-0">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="section-head">
          <h2 class="section-title">
           Get the Taste of <a href="https://prime.edu.np/prime-in-picture"><span>Prime</span></a> Experience!          </h2>
          <div class="d-sm-flex justify-content-between">
                        </div>
        </div>
      </div>
    </div>
  </div>
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-12">
        <div class="exp-card-wrap">
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2023/08/20230114_130656-scaled.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-123-of-909-scaled.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2024/03/419737599_387032610787660_4127246294101307592_n.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2023/08/318427742_2079352288938708_7122442755432514774_n.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-975-of-592-scaled.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2023/08/335945192_224093113494929_836574114928973099_n.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-61-of-909-scaled.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2024/05/441149137_419922100832044_3384739801662751191_n.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2023/08/333049163_747544856688967_5186421015281104183_n.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2024/03/420173062_387030260787895_1599942019332965253_n.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2024/03/417591592_387029090788012_8119324254296562582_n-edited.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2023/08/331910911_203118139000523_305516247075393383_n.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-773-of-909-scaled.jpg" alt="#">
                    </div>
            </div>
                      
        </div>
      </div>
    </div>
  </div>
</div>
<!-- End Prime Experience Center -->


<!-- Start Our Program -->
<div class="our-program-section block">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="section-head">
          <h2 class="section-title">
            Our Programs
          </h2>
        </div>
        <div class="swiper our-program-slider">
          <!-- Additional required wrapper -->
          <div class="swiper-wrapper">
            <!-- Slides -->
                         <div class="swiper-slide">
              <div class="program-card card">
                <div class="card-img">
                 <img width="1707" height="2560" src="https://prime.edu.np/wp-content/uploads/2023/07/BSc.-CSIT-Program-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/BSc.-CSIT-Program-scaled.jpg 1707w, https://prime.edu.np/wp-content/uploads/2023/07/BSc.-CSIT-Program-200x300.jpg 200w, https://prime.edu.np/wp-content/uploads/2023/07/BSc.-CSIT-Program-683x1024.jpg 683w, https://prime.edu.np/wp-content/uploads/2023/07/BSc.-CSIT-Program-768x1152.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/07/BSc.-CSIT-Program-1024x1536.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/BSc.-CSIT-Program-1365x2048.jpg 1365w" sizes="(max-width: 1707px) 100vw, 1707px" />                </div>
                <div class="card-body">
                  <div class="faculty">BSc.CSIT</div>
                  <h4 class="equal-height"><a href="https://prime.edu.np/program/bachelors-of-science-in-csit/">Bachelor of Science in Computer Science and Information Technology</a></h4>
                  <a href="https://prime.edu.np/program/bachelors-of-science-in-csit/" class="view-link">View Detail</a>
                </div>
                <a href="https://prime.edu.np/program/bachelors-of-science-in-csit/" class="program-card-detail">
                  <h4>Bachelor of Science in Computer Science and Information Technology</h4>
                  <div class="program-feature">
                     <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/graduation-cal.png" alt="#"></span>
                                <div class="info">
                                    <p>Semester/Year</p>
                                    <h5>8 Semesters, 4  Years</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/clock.png" alt="#"></span>
								
                                <div class="info">
                                    <p>Credit Hours</p>
                                    <h5>126 Hrs</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/sun.png" alt="#"></span>
                                <div class="info">
                                    <p>Timing</p>
                                    <h5>Morning</h5>
                                </div>
                            </div>
                            <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/note.png" alt="#"></span>
                                <div class="info">
                                    <p>Entrance Exam</p>
                                    <h5>IOST</h5>
                                </div>
                            </div>

                  </div>
<!--                   <a href="https://prime.edu.np/program/bachelors-of-science-in-csit/" class="view-link">View Detail</a> -->
                </a>
              </div>
            </div>
                       <div class="swiper-slide">
              <div class="program-card card">
                <div class="card-img">
                 <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/07/BCA-Program-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/BCA-Program-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/07/BCA-Program-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/07/BCA-Program-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/BCA-Program-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/07/BCA-Program-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/07/BCA-Program-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />                </div>
                <div class="card-body">
                  <div class="faculty">BCA</div>
                  <h4 class="equal-height"><a href="https://prime.edu.np/program/bachelor-of-computer-applications/">Bachelor of Computer Applications</a></h4>
                  <a href="https://prime.edu.np/program/bachelor-of-computer-applications/" class="view-link">View Detail</a>
                </div>
                <a href="https://prime.edu.np/program/bachelor-of-computer-applications/" class="program-card-detail">
                  <h4>Bachelor of Computer Applications</h4>
                  <div class="program-feature">
                     <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/graduation-cal.png" alt="#"></span>
                                <div class="info">
                                    <p>Semester/Year</p>
                                    <h5>8 Semesters, 4 Years</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/clock.png" alt="#"></span>
								
                                <div class="info">
                                    <p>Credit Hours</p>
                                    <h5>126 Hrs</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/sun.png" alt="#"></span>
                                <div class="info">
                                    <p>Timing</p>
                                    <h5>Morning</h5>
                                </div>
                            </div>
                            <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/note.png" alt="#"></span>
                                <div class="info">
                                    <p>Entrance Exam</p>
                                    <h5>BCA </h5>
                                </div>
                            </div>

                  </div>
<!--                   <a href="https://prime.edu.np/program/bachelor-of-computer-applications/" class="view-link">View Detail</a> -->
                </a>
              </div>
            </div>
                       <div class="swiper-slide">
              <div class="program-card card">
                <div class="card-img">
                 <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/07/BBA-Program-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/BBA-Program-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/07/BBA-Program-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/07/BBA-Program-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/BBA-Program-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/07/BBA-Program-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/07/BBA-Program-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />                </div>
                <div class="card-body">
                  <div class="faculty">BBA</div>
                  <h4 class="equal-height"><a href="https://prime.edu.np/program/bachelor-of-business-administration/">Bachelor of Business Administration</a></h4>
                  <a href="https://prime.edu.np/program/bachelor-of-business-administration/" class="view-link">View Detail</a>
                </div>
                <a href="https://prime.edu.np/program/bachelor-of-business-administration/" class="program-card-detail">
                  <h4>Bachelor of Business Administration</h4>
                  <div class="program-feature">
                     <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/graduation-cal.png" alt="#"></span>
                                <div class="info">
                                    <p>Semester/Year</p>
                                    <h5>8 Semesters, 4  Years</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/clock.png" alt="#"></span>
								
                                <div class="info">
                                    <p>Credit Hours</p>
                                    <h5>120  Hrs</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/sun.png" alt="#"></span>
                                <div class="info">
                                    <p>Timing</p>
                                    <h5>Morning / Day</h5>
                                </div>
                            </div>
                            <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/note.png" alt="#"></span>
                                <div class="info">
                                    <p>Entrance Exam</p>
                                    <h5>CMAT </h5>
                                </div>
                            </div>

                  </div>
<!--                   <a href="https://prime.edu.np/program/bachelor-of-business-administration/" class="view-link">View Detail</a> -->
                </a>
              </div>
            </div>
                       <div class="swiper-slide">
              <div class="program-card card">
                <div class="card-img">
                 <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/07/BIM-Program-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/BIM-Program-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/07/BIM-Program-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/07/BIM-Program-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/BIM-Program-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/07/BIM-Program-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/07/BIM-Program-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />                </div>
                <div class="card-body">
                  <div class="faculty">BIM</div>
                  <h4 class="equal-height"><a href="https://prime.edu.np/program/bim/">Bachelor of Information Management</a></h4>
                  <a href="https://prime.edu.np/program/bim/" class="view-link">View Detail</a>
                </div>
                <a href="https://prime.edu.np/program/bim/" class="program-card-detail">
                  <h4>Bachelor of Information Management</h4>
                  <div class="program-feature">
                     <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/graduation-cal.png" alt="#"></span>
                                <div class="info">
                                    <p>Semester/Year</p>
                                    <h5>8 Semesters, 4 Years</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/clock.png" alt="#"></span>
								
                                <div class="info">
                                    <p>Credit Hours</p>
                                    <h5>126 Hrs</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/sun.png" alt="#"></span>
                                <div class="info">
                                    <p>Timing</p>
                                    <h5>Day</h5>
                                </div>
                            </div>
                            <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/note.png" alt="#"></span>
                                <div class="info">
                                    <p>Entrance Exam</p>
                                    <h5> CMAT </h5>
                                </div>
                            </div>

                  </div>
<!--                   <a href="https://prime.edu.np/program/bim/" class="view-link">View Detail</a> -->
                </a>
              </div>
            </div>
                       <div class="swiper-slide">
              <div class="program-card card">
                <div class="card-img">
                 <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/07/BBM-Program-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/BBM-Program-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/07/BBM-Program-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/07/BBM-Program-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/BBM-Program-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/07/BBM-Program-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/07/BBM-Program-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />                </div>
                <div class="card-body">
                  <div class="faculty">BBM</div>
                  <h4 class="equal-height"><a href="https://prime.edu.np/program/bbm/">Bachelor of Business Management</a></h4>
                  <a href="https://prime.edu.np/program/bbm/" class="view-link">View Detail</a>
                </div>
                <a href="https://prime.edu.np/program/bbm/" class="program-card-detail">
                  <h4>Bachelor of Business Management</h4>
                  <div class="program-feature">
                     <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/graduation-cal.png" alt="#"></span>
                                <div class="info">
                                    <p>Semester/Year</p>
                                    <h5>8 Semesters, 4  Years</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/clock.png" alt="#"></span>
								
                                <div class="info">
                                    <p>Credit Hours</p>
                                    <h5>120 Hrs</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/sun.png" alt="#"></span>
                                <div class="info">
                                    <p>Timing</p>
                                    <h5>Morning</h5>
                                </div>
                            </div>
                            <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/note.png" alt="#"></span>
                                <div class="info">
                                    <p>Entrance Exam</p>
                                    <h5>CMAT</h5>
                                </div>
                            </div>

                  </div>
<!--                   <a href="https://prime.edu.np/program/bbm/" class="view-link">View Detail</a> -->
                </a>
              </div>
            </div>
                       <div class="swiper-slide">
              <div class="program-card card">
                <div class="card-img">
                 <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/08/BBS-Program-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/08/BBS-Program-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/08/BBS-Program-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/08/BBS-Program-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/08/BBS-Program-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/08/BBS-Program-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/08/BBS-Program-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />                </div>
                <div class="card-body">
                  <div class="faculty">BBS</div>
                  <h4 class="equal-height"><a href="https://prime.edu.np/program/bachelor-of-business-studies/">Bachelor of Business Studies</a></h4>
                  <a href="https://prime.edu.np/program/bachelor-of-business-studies/" class="view-link">View Detail</a>
                </div>
                <a href="https://prime.edu.np/program/bachelor-of-business-studies/" class="program-card-detail">
                  <h4>Bachelor of Business Studies</h4>
                  <div class="program-feature">
                     <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/graduation-cal.png" alt="#"></span>
                                <div class="info">
                                    <p>Semester/Year</p>
                                    <h5>4 Years</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/sun.png" alt="#"></span>
                                <div class="info">
                                    <p>Timing</p>
                                    <h5>Morning</h5>
                                </div>
                            </div>
                            <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/note.png" alt="#"></span>
                                <div class="info">
                                    <p>Entrance Exam</p>
                                    <h5>No entrance</h5>
                                </div>
                            </div>

                  </div>
<!--                   <a href="https://prime.edu.np/program/bachelor-of-business-studies/" class="view-link">View Detail</a> -->
                </a>
              </div>
            </div>
                       <div class="swiper-slide">
              <div class="program-card card">
                <div class="card-img">
                 <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/07/MBS-Program-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/MBS-Program-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/07/MBS-Program-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/07/MBS-Program-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/MBS-Program-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/07/MBS-Program-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/07/MBS-Program-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />                </div>
                <div class="card-body">
                  <div class="faculty">MBS</div>
                  <h4 class="equal-height"><a href="https://prime.edu.np/program/mbs/">Master of Business Studies</a></h4>
                  <a href="https://prime.edu.np/program/mbs/" class="view-link">View Detail</a>
                </div>
                <a href="https://prime.edu.np/program/mbs/" class="program-card-detail">
                  <h4>Master of Business Studies</h4>
                  <div class="program-feature">
                     <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/graduation-cal.png" alt="#"></span>
                                <div class="info">
                                    <p>Semester/Year</p>
                                    <h5>4 Semesters, 2  Years</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/clock.png" alt="#"></span>
								
                                <div class="info">
                                    <p>Credit Hours</p>
                                    <h5>60 Hrs</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/sun.png" alt="#"></span>
                                <div class="info">
                                    <p>Timing</p>
                                    <h5>Morning</h5>
                                </div>
                            </div>
                            <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/note.png" alt="#"></span>
                                <div class="info">
                                    <p>Entrance Exam</p>
                                    <h5>CMAT(MBS)</h5>
                                </div>
                            </div>

                  </div>
<!--                   <a href="https://prime.edu.np/program/mbs/" class="view-link">View Detail</a> -->
                </a>
              </div>
            </div>
                     </div>
          <!-- If we need navigation buttons -->
          <div class="swiper-button-prev"></div>
          <div class="swiper-button-next"></div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- End Our Program -->

<!-- Start Prime In Number -->
<div class="prime-in-number block" style="background-image: url('https://prime.edu.np/wp-content/themes/prime-college/assets/img/prime-num-bg.jpg');">
  <div class="container position-relative">
    <div class="row">
      <div class="col-md-12">
        <div class="section-head">
          <h2 class="section-title text-center">Prime in Numbers</h2>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <div class="number-hex-wrap">
          <div class="grid">
            <div class="col1">
              <div class="hex d-none d-md-block">
                <div class="hex-inner">
                  <img src="https://prime.edu.np/wp-content/uploads/2025/01/24.png" alt="">
                  <p>Years of Excellence</p>
                </div>
              </div>
            </div>
            <div class="col2">
              <div class="hex">
                <div class="hex-inner">
                  <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/book.svg" alt="">
                  <h5>7</h5>
                  <p>Programs Launched</p>
                </div>
              </div>
              <div class="hex">
                <div class="hex-inner">
                  <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/cap.svg" alt="">
                  <h5>4000+</h5>
                  <p>graduates from 7 programs in 20 years</p>
                </div>
              </div>
            </div>
            <div class="col3">
            <div class="hex d-md-none">
                <div class="hex-inner">
                  <img src="https://prime.edu.np/wp-content/uploads/2025/01/24.png" alt="">
                  <p>Years of Excellence</p>
                </div>
              </div>
              <div class="hex mid-hex">
                <div class="hex-inner">
                  <div class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/graduate.svg" alt="#"></div>
                  <div class="content">
                    <h5>25+</h5>
                    <p>TU Toppers in the Last 10 Years</p>
                  </div>
                </div>
              </div>
              <div class="hex d-md-none">
                <div class="hex-inner">
                  <img src="https://prime.edu.np/wp-content/uploads/2023/08/7.svg" alt="">
                  <p>Clubs established grown to over <strong>1000</strong> members</p>
                </div>
              </div>
            </div>
            <div class="col4">
              <div class="hex">
                <div class="hex-inner">
                  <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/trophy.svg" alt="">
                  <h5>50+</h5>
                  <p>Awards &amp; Competitions Won by Prime College</p>
                </div>
              </div>
              <div class="hex">
                <div class="hex-inner">
                  <div class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/graduate.svg" alt="#"></div>
                  <div class="content">
                    <h5>500+</h5>
                    <p>Distinctions in the last 5 years</p>
                  </div>
                </div>
              </div>
            </div>
            <div class="col5">
              <div class="hex d-none d-md-block">
                <div class="hex-inner">
                  <img src="https://prime.edu.np/wp-content/uploads/2023/08/7.svg" alt="">
                  <p>Clubs established grown to over <strong>1000</strong> members</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- End Prime In Number -->

<div class="chart-section block">
  <div class="container">
    <div class="row align-items-center">
      <div class="col-md-7 col-lg-8">
        <div class="chart-wrap">
          <div class="mid-circle-wrap">
            <div class="mid-circle"> Why Join Prime?</div>
          </div>
          <div class="pie-wrap">
          <div id="one" class="pie one">
            <a href="https://prime.edu.np/mlrc/"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/pie-shape2.png" alt=""></a>
          </div>
          </div>
          <div class="pie-wrap">
          <div id="two" class="pie two"><a href="https://prime.edu.np/career/"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/pie-shape3.png" alt=""></a>
          </div>
          </div>
          <div class="pie-wrap">
          <div id="three" class="pie three"><a href="https://prime.edu.np/eso/"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/pie-shape4.png" alt=""></a>
          </div></div>
          <div class="pie-wrap">
          <div id="four" class="pie four"><a href="https://prime.edu.np/"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/pie-shape5.png" alt=""></a></div></div>
            <div class="pie-wrap">
          <div id="five" class="pie five"><a href="https://prime.edu.np/team/"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/pie-shape6.png" alt=""></a></div></div>
            <div class="pie-wrap">
          <div id="six" class="pie six"><a href="https://prime.edu.np/"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/pie-shape7.png" alt="#"></a></div></div>
            <div class="pie-wrap">
          <div id="seven" class="pie seven"><a href="https://prime.edu.np/infrastructure/"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/pie-shape1.png" alt=""></a></div></div>
        </div>
        
      </div>
      <div class="col-md-5 col-lg-4">
        <div class="chart-content-wrap position-relative">
            <div class="arrow-icon">
              <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/arrow.png"/>
          </div>
                      <div id="content-one" class="card card-content">
            <div class="card-img">
              <img src="https://prime.edu.np/wp-content/uploads/2023/08/GOP_2470-Edited-scaled.jpg" alt="#">
            </div>
            <div class="card-body">
              <h4>Mathema Learning Resource Center</h4>
              <ul>
<li>Boost your skills with Value Added Courses</li>
<li> Get involved with the Prime Clubs</li>
</ul>
              <a href="https://prime.edu.np/mlrc/" class="btn btn-sm btn-light">View Detail</a>
            </div>
          </div>
                     <div id="content-two" class="card card-content">
            <div class="card-img">
              <img src="https://prime.edu.np/wp-content/uploads/2023/08/PCC-1-scaled.jpg" alt="#">
            </div>
            <div class="card-body">
              <h4>Prime Career Center</h4>
              <p>Job placement offers that match your skillset</p>
              <a href="https://prime.edu.np/career/" class="btn btn-sm btn-light">View Detail</a>
            </div>
          </div>
                     <div id="content-three" class="card card-content">
            <div class="card-img">
              <img src="https://prime.edu.np/wp-content/uploads/2023/08/ESO-1-scaled.jpg" alt="#">
            </div>
            <div class="card-body">
              <h4>Prime Wellness Center</h4>
              <p>Embracing mental wellness together: We care about you.</p>
              <a href="https://prime.edu.np/eso/" class="btn btn-sm btn-light">View Detail</a>
            </div>
          </div>
                     <div id="content-four" class="card card-content">
            <div class="card-img">
              <img src="https://prime.edu.np/wp-content/uploads/2023/08/GOP_2480-Edited-scaled.jpg" alt="#">
            </div>
            <div class="card-body">
              <h4>Engaging Co-Curricular Activities</h4>
              <p>Experience the extravagance of our activities.</p>
              <a href="https://prime.edu.np/student-%20club/" class="btn btn-sm btn-light">View Detail</a>
            </div>
          </div>
                     <div id="content-five" class="card card-content">
            <div class="card-img">
              <img src="https://prime.edu.np/wp-content/uploads/2023/08/GOP_2490-Edited-scaled.jpg" alt="#">
            </div>
            <div class="card-body">
              <h4>Support along the Way</h4>
              <p>Friendly Faculties, Lifelong Mentors.</p>
              <a href="https://prime.edu.np/team/" class="btn btn-sm btn-light">View Detail</a>
            </div>
          </div>
                     <div id="content-six" class="card card-content">
            <div class="card-img">
              <img src="https://prime.edu.np/wp-content/uploads/2023/08/Build-Your-Network-scaled.jpg" alt="#">
            </div>
            <div class="card-body">
              <h4>Build your Network</h4>
              <p>Join hands with creative minds</p>
              <a href="" class="btn btn-sm btn-light">View Detail</a>
            </div>
          </div>
                     <div id="content-seven" class="card card-content">
            <div class="card-img">
              <img src="https://prime.edu.np/wp-content/uploads/2023/08/Progressive-Infrastructure-scaled.jpg" alt="#">
            </div>
            <div class="card-body">
              <h4>Progressive Infrastructure</h4>
              <p>Create your foundation with our Progressive Infrastructures</p>
              <a href="https://prime.edu.np/infrastructure/" class="btn btn-sm btn-light">View Detail</a>
            </div>
          </div>
                   </div>
      </div>
    </div>
  </div>
</div>

<!-- Start Testimonials -->
<div class="testimonial-section block">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="section-head">
          <h2 class="section-title">Student's Experience</h2>
        </div>
      </div>
    </div>
    <div class="row justify-content-center srow">
      <div class="col-md-12 col-xl-10">
        <!-- Slider main container -->
        <div class="swiper testimonial-slider">
          <!-- Additional required wrapper -->
          <div class="swiper-wrapper">
            <!-- Slides -->
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3>Nirjala Shakya</h3>
                <p>BCA</p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                Prime College has been more than just an academic journey for me—it’s been a platform for growth and opportunity. Through my involvement in student clubs, I’ve enhanced my skills, expanded my network, and gained invaluable hands-on experience as an IT student. These experiences have been truly rewarding, enriching my portfolio and shaping my professional journey. 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2025/01/Screenshot-2025-01-13-142734.png" alt="#">
              </div>
            </div>
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3>Srijal Kapri</h3>
                <p>BSc. CSIT</p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                Prime College has been an incredible place for my academic growth. The faculty members, especially the IT Coordinator, are exceptionally supportive, knowledgeable, and dedicated to student performance. Their expertise and friendly approach make learning effective and engaging. The college environment is really good for learning as it believes in innovation and exploration. Additionally, the various student clubs that organize different programs make the college experience more entertaining and informative.


I truly appreciate how friendly, experienced, and qualified all the teachers in their field. Their guidance has not only uplifted my academics but also inspired me to develop personally. Choosing a prime college has been one of the best decisions and I am proud to be part of such a great institution. 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2025/01/0-02-03-b57e6073314c1aeabdab2212126e28fbc27055ba8e23b39a3401a52b6f75851b_935e8ec5a8965e16.jpg" alt="#">
              </div>
            </div>
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3>Subha Thapa</h3>
                <p>BBM </p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                Prime College has played a key role in shaping my educational and personal growth. The perfect combination of interactive faculty members, a positive learning environment, and enriching extracurricular activities has enhanced my creativity, knowledge, and overall perspective on life. Being a part of the Prime Entrepreneurial Management Club (EMC) has provided invaluable insights into entrepreneurship and strengthened my foundation for the future. My time at Prime has been eventful and productive defining my career path and transforming my approach to challenges and opportunities. I am truly grateful for the experiences and guidance I’ve received and look forward to continuing to contribute to this vibrant community, even after graduation. 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2023/08/subha.jpg" alt="#">
              </div>
            </div>
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3>Yunika Shakya</h3>
                <p>BSc. CSIT </p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                Prime College provided me with a path to learn and experience new things. It has facilitated my growth and development. Participating in college clubs and activities in a friendly environment and having supportive teachers and coordinators were plus points for me. Also, getting an opportunity to be an intern as a Creative Designer at MLRC enhanced my personal and professional growth. It allowed me to apply and grow my knowledge/ skills in real-world projects. Prime College has had a positive impact in my life. I highly recommend it to anyone looking for a college that challenges and supports them in achieving their goals.
 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2023/08/Yunika-Shakya-scaled.jpg" alt="#">
              </div>
            </div>
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3>Mamata Adhikari</h3>
                <p>BBM </p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                Prime College provides a platform for students to explore and work on their endeavours. The faculty members are knowledgeable experts and passionate mentors who go above and beyond to ensure success. Furthermore, seminars and clubs provide valuable knowledge and experience.
 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2023/08/Mamata-Adhikari-scaled.jpg" alt="#">
              </div>
            </div>
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3> Yashu Sthapit</h3>
                <p>BIM </p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                Prime College has exceeded my expectations in every aspect. The knowledgeable faculty and supportive environment have truly shaped my academic journey and prepared me for future success.
 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2023/08/Yashu-Sthapit-scaled.jpg" alt="#">
              </div>
            </div>
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3>Anjali Khanal</h3>
                <p>MBS </p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                Being a student of Prime College has actually changed me for the better. The challenging education, helpful environment, and enthusiastic lecturers have actually equipped me for my future job. Numerous training and workshops provided by the college have also helped me forge lifetime connections, gain experiences and develop my Inter/Intra personal skills. I am very much proud to be a student of this institution. 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2023/08/Anjali-Khanal-scaled.jpg" alt="#">
              </div>
            </div>
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3>Bishan Poudel</h3>
                <p>BCA </p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                I would like to express my heartfelt gratitude to Prime College for providing me with such a fantastic learning experience and job opportunities. My college was able to hone my skills and prepare me as a better member of the community. The college has an excellent placement cell, tied up with several top-notch companies. I have been fortunate enough to be offered a job by one of these companies. I would highly recommend this institution to anyone who is looking for quality education and a great gateway to start their corporate life. 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2023/09/image-43.png" alt="#">
              </div>
            </div>
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3>Sudikshya Sharma</h3>
                <p>BBA </p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                It is my immense fortune to be a part of Prime College. The entire faculty and department leaves no stone unturned to shape one’s future. Huge respect, love, and devotion for the entire faculty members and department. It is their effort that encourages me to count myself into a better profession. 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2023/08/Sudikshya-Sharma-scaled.jpg" alt="#">
              </div>
            </div>
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3>Shreeya Shrestha</h3>
                <p>BBS </p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                Studying at Prime College for these past few months has been an absolute blast as I am learning new things every day, and I feel like I am also growing as a person. Studying at Prime College has been by far one of the best decisions of my life and I have yet to explore the college fully and participate in future club activities, which I am looking forward to. 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2023/08/Shreeya-Shrestha-scaled.jpg" alt="#">
              </div>
            </div>
              
            
          </div>

          <!-- If we need navigation buttons -->
          <div class="swiper-button-prev"></div>
          <div class="swiper-button-next"></div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- End Testimonials -->



<!-- Start News And Event -->
<div class="news-event block pb-0">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="section-head">
          <h2 class="section-title">
            News and Events
          </h2>
          <div class="d-sm-flex justify-content-between">
            <p>Latest Events</p>
            <a href="https://prime.edu.np/events/" class="link">View All</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="news-event-area">
    <!-- Slider main container -->
    <div class="swiper news-event-slider">
      <!-- Additional required wrapper -->
      <div class="swiper-wrapper">
        <!-- Slides -->
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/12/Webinar_KPMG.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/Webinar_KPMG.png 1080w, https://prime.edu.np/wp-content/uploads/2024/12/Webinar_KPMG-300x300.png 300w, https://prime.edu.np/wp-content/uploads/2024/12/Webinar_KPMG-1024x1024.png 1024w, https://prime.edu.np/wp-content/uploads/2024/12/Webinar_KPMG-150x150.png 150w, https://prime.edu.np/wp-content/uploads/2024/12/Webinar_KPMG-768x768.png 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 4, 2024</div>
              <h4><a href="https://prime.edu.np/event/webinar-the-financial-anatomy-of-ipl-lessons-in-accounting/">Webinar &#8211; The Financial Anatomy of IPL: Lessons in Accounting</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1440" height="1440" src="https://prime.edu.np/wp-content/uploads/2024/12/470795809_543619352001990_3125569174070596708_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/470795809_543619352001990_3125569174070596708_n.jpg 1440w, https://prime.edu.np/wp-content/uploads/2024/12/470795809_543619352001990_3125569174070596708_n-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/12/470795809_543619352001990_3125569174070596708_n-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/12/470795809_543619352001990_3125569174070596708_n-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2024/12/470795809_543619352001990_3125569174070596708_n-768x768.jpg 768w" sizes="(max-width: 1440px) 100vw, 1440px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 18, 2024</div>
              <h4><a href="https://prime.edu.np/event/ink-and-imagination-vol-2-prime-flair-club/">Ink and Imagination Vol-2 | Prime Flair Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/12/468839188_9777254668959531_4122224525569538738_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/468839188_9777254668959531_4122224525569538738_n.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/12/468839188_9777254668959531_4122224525569538738_n-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/12/468839188_9777254668959531_4122224525569538738_n-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/12/468839188_9777254668959531_4122224525569538738_n-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2024/12/468839188_9777254668959531_4122224525569538738_n-768x768.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 3, 2024</div>
              <h4><a href="https://prime.edu.np/event/digital-marketing-workshop/">Digital Marketing Workshop</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/12/472036317_9928127880538875_8424459098420205738_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/472036317_9928127880538875_8424459098420205738_n.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/12/472036317_9928127880538875_8424459098420205738_n-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/12/472036317_9928127880538875_8424459098420205738_n-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/12/472036317_9928127880538875_8424459098420205738_n-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2024/12/472036317_9928127880538875_8424459098420205738_n-768x768.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 31, 2024</div>
              <h4><a href="https://prime.edu.np/event/jamacho-hike-mlrc/">Jamacho Hike | MLRC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2048" height="2048" src="https://prime.edu.np/wp-content/uploads/2025/01/473254283_997418485753934_6911098037935191120_n-1.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2025/01/473254283_997418485753934_6911098037935191120_n-1.jpg 2048w, https://prime.edu.np/wp-content/uploads/2025/01/473254283_997418485753934_6911098037935191120_n-1-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2025/01/473254283_997418485753934_6911098037935191120_n-1-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2025/01/473254283_997418485753934_6911098037935191120_n-1-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2025/01/473254283_997418485753934_6911098037935191120_n-1-768x768.jpg 768w, https://prime.edu.np/wp-content/uploads/2025/01/473254283_997418485753934_6911098037935191120_n-1-1536x1536.jpg 1536w" sizes="(max-width: 2048px) 100vw, 2048px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 9, 2025</div>
              <h4><a href="https://prime.edu.np/event/%f0%9d%90%93%f0%9d%90%a1%f0%9d%90%9e-%f0%9d%90%86%f0%9d%90%88%f0%9d%90%86-%f0%9d%90%84%f0%9d%90%9c%f0%9d%90%a8%f0%9d%90%a7%f0%9d%90%a8%f0%9d%90%a6%f0%9d%90%b2-%f0%9d%90%82%f0%9d%90%9a%f0%9d%90%a7/">The GIG Economy: Can learning and earning coexist in colleges of Nepal? | Panel Discussion</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2025/01/473688466_18259991296260140_3630701444883683255_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2025/01/473688466_18259991296260140_3630701444883683255_n.jpg 1080w, https://prime.edu.np/wp-content/uploads/2025/01/473688466_18259991296260140_3630701444883683255_n-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2025/01/473688466_18259991296260140_3630701444883683255_n-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2025/01/473688466_18259991296260140_3630701444883683255_n-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2025/01/473688466_18259991296260140_3630701444883683255_n-768x768.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 16, 2025</div>
              <h4><a href="https://prime.edu.np/event/idea-to-impact-turning-visions-into-reality-prime-emc/">Idea to Impact: Turning Visions into Reality | Prime EMC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1350" height="1687" src="https://prime.edu.np/wp-content/uploads/2024/12/470014409_18293707333235746_3753962910426197010_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/470014409_18293707333235746_3753962910426197010_n.jpg 1350w, https://prime.edu.np/wp-content/uploads/2024/12/470014409_18293707333235746_3753962910426197010_n-240x300.jpg 240w, https://prime.edu.np/wp-content/uploads/2024/12/470014409_18293707333235746_3753962910426197010_n-819x1024.jpg 819w, https://prime.edu.np/wp-content/uploads/2024/12/470014409_18293707333235746_3753962910426197010_n-768x960.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/12/470014409_18293707333235746_3753962910426197010_n-1229x1536.jpg 1229w" sizes="(max-width: 1350px) 100vw, 1350px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 16, 2024</div>
              <h4><a href="https://prime.edu.np/event/shrijay-memorial-ict-cup-2025-prime-it-club/">SHRIJAY MEMORIAL ICT CUP 2025 | Prime IT Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1350" src="https://prime.edu.np/wp-content/uploads/2024/11/468701085_1100631758519761_186031010732411699_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/11/468701085_1100631758519761_186031010732411699_n.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/11/468701085_1100631758519761_186031010732411699_n-240x300.jpg 240w, https://prime.edu.np/wp-content/uploads/2024/11/468701085_1100631758519761_186031010732411699_n-819x1024.jpg 819w, https://prime.edu.np/wp-content/uploads/2024/11/468701085_1100631758519761_186031010732411699_n-768x960.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Nov 24, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-sports-gala-2081-prime-sports-club/">21st Prime Sports Gala 2081 | Prime Sports Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="609" height="714" src="https://prime.edu.np/wp-content/uploads/2024/11/Screen-Shot-2024-11-21-at-10.30.23-AM.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/11/Screen-Shot-2024-11-21-at-10.30.23-AM.png 609w, https://prime.edu.np/wp-content/uploads/2024/11/Screen-Shot-2024-11-21-at-10.30.23-AM-256x300.png 256w" sizes="(max-width: 609px) 100vw, 609px" />            </div>
            <div class="card-body">
              <div class="post-date">Nov 21, 2024</div>
              <h4><a href="https://prime.edu.np/event/starting-in-it-field-prime-it-club/">Starting in IT Field | Prime IT Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1350" src="https://prime.edu.np/wp-content/uploads/2024/11/Social-Media-Post-Orientation-2081.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/11/Social-Media-Post-Orientation-2081.png 1080w, https://prime.edu.np/wp-content/uploads/2024/11/Social-Media-Post-Orientation-2081-240x300.png 240w, https://prime.edu.np/wp-content/uploads/2024/11/Social-Media-Post-Orientation-2081-819x1024.png 819w, https://prime.edu.np/wp-content/uploads/2024/11/Social-Media-Post-Orientation-2081-768x960.png 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Nov 13, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-orientation-program-2081/">Prime Orientation Program 2081</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1349" src="https://prime.edu.np/wp-content/uploads/2024/11/465375938_1081515457098058_1024475649769892061_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/11/465375938_1081515457098058_1024475649769892061_n.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/11/465375938_1081515457098058_1024475649769892061_n-240x300.jpg 240w, https://prime.edu.np/wp-content/uploads/2024/11/465375938_1081515457098058_1024475649769892061_n-820x1024.jpg 820w, https://prime.edu.np/wp-content/uploads/2024/11/465375938_1081515457098058_1024475649769892061_n-768x959.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Nov 6, 2024</div>
              <h4><a href="https://prime.edu.np/event/inter-club-futsal-tournament/">Inter-Club Futsal Tournament</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1350" height="1687" src="https://prime.edu.np/wp-content/uploads/2024/10/464620039_529814369842816_2069891356149677695_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/10/464620039_529814369842816_2069891356149677695_n.jpg 1350w, https://prime.edu.np/wp-content/uploads/2024/10/464620039_529814369842816_2069891356149677695_n-240x300.jpg 240w, https://prime.edu.np/wp-content/uploads/2024/10/464620039_529814369842816_2069891356149677695_n-819x1024.jpg 819w, https://prime.edu.np/wp-content/uploads/2024/10/464620039_529814369842816_2069891356149677695_n-768x960.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/10/464620039_529814369842816_2069891356149677695_n-1229x1536.jpg 1229w" sizes="(max-width: 1350px) 100vw, 1350px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 29, 2024</div>
              <h4><a href="https://prime.edu.np/event/deusi-bhailo-2081/">Deusi Bhailo 2081</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/10/462483042_516401944517392_1117041747096679010_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/10/462483042_516401944517392_1117041747096679010_n.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/10/462483042_516401944517392_1117041747096679010_n-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/10/462483042_516401944517392_1117041747096679010_n-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/10/462483042_516401944517392_1117041747096679010_n-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2024/10/462483042_516401944517392_1117041747096679010_n-768x768.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 17, 2024</div>
              <h4><a href="https://prime.edu.np/event/kpmg-us-cpa-united-states-certified-public-accountant-webinar/">KPMG US CPA (United States Certified Public Accountant) &#8211; Webinar</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1441" src="https://prime.edu.np/wp-content/uploads/2024/10/PCDC-23-of-45-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/10/PCDC-23-of-45-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2024/10/PCDC-23-of-45-300x169.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/10/PCDC-23-of-45-1024x577.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/10/PCDC-23-of-45-768x432.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/10/PCDC-23-of-45-1536x865.jpg 1536w, https://prime.edu.np/wp-content/uploads/2024/10/PCDC-23-of-45-2048x1153.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 4, 2024</div>
              <h4><a href="https://prime.edu.np/event/changa-chait-program-mlrc/">Prime College Celebrates Dashain with Joy and Tradition | MLRC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1448" height="2048" src="https://prime.edu.np/wp-content/uploads/2024/09/460124658_1058889395628617_5927326607711363784_n.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/09/460124658_1058889395628617_5927326607711363784_n.png 1448w, https://prime.edu.np/wp-content/uploads/2024/09/460124658_1058889395628617_5927326607711363784_n-212x300.png 212w, https://prime.edu.np/wp-content/uploads/2024/09/460124658_1058889395628617_5927326607711363784_n-724x1024.png 724w, https://prime.edu.np/wp-content/uploads/2024/09/460124658_1058889395628617_5927326607711363784_n-768x1086.png 768w, https://prime.edu.np/wp-content/uploads/2024/09/460124658_1058889395628617_5927326607711363784_n-1086x1536.png 1086w" sizes="(max-width: 1448px) 100vw, 1448px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 8, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-club-executive-night-2081-mlrc/">Prime Club Executive Night 2081: A Celebration of Connection and Collaboration | MLRC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/09/KMPG.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/09/KMPG.png 1080w, https://prime.edu.np/wp-content/uploads/2024/09/KMPG-300x300.png 300w, https://prime.edu.np/wp-content/uploads/2024/09/KMPG-1024x1024.png 1024w, https://prime.edu.np/wp-content/uploads/2024/09/KMPG-150x150.png 150w, https://prime.edu.np/wp-content/uploads/2024/09/KMPG-768x768.png 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Sep 24, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-college-collaborates-with-kpmg-in-india-to-introduce-one-of-the-first-ever-us-cpa-test-preparation-programs-in-nepal/">Prime College Collaborates with KPMG in India to Introduce one of the first ever US CPA Test Preparation Programs in Nepal</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/07/Reformation.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/07/Reformation.png 1080w, https://prime.edu.np/wp-content/uploads/2024/07/Reformation-300x300.png 300w, https://prime.edu.np/wp-content/uploads/2024/07/Reformation-1024x1024.png 1024w, https://prime.edu.np/wp-content/uploads/2024/07/Reformation-150x150.png 150w, https://prime.edu.np/wp-content/uploads/2024/07/Reformation-768x768.png 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Sep 11, 2024</div>
              <h4><a href="https://prime.edu.np/event/student-club-reformation-2081/">Prime College Hosts Student Club Reformation Program: A Celebration of Leadership and Community</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/09/459151022_954038256766726_6924652427114122476_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/09/459151022_954038256766726_6924652427114122476_n.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/09/459151022_954038256766726_6924652427114122476_n-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/09/459151022_954038256766726_6924652427114122476_n-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/09/459151022_954038256766726_6924652427114122476_n-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2024/09/459151022_954038256766726_6924652427114122476_n-768x768.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Sep 11, 2024</div>
              <h4><a href="https://prime.edu.np/event/indra-jatra-prime-cultural-club/">INDRA JATRA | Prime Cultural Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-756-of-909-1-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-756-of-909-1-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-756-of-909-1-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-756-of-909-1-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-756-of-909-1-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-756-of-909-1-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-756-of-909-1-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Aug 13, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-graduation-ceremony-2081/">Prime Graduation Ceremony 2081: A Celebration of Achievement and Aspiration</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="828" height="1169" src="https://prime.edu.np/wp-content/uploads/2024/07/Eduroam.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="Prime College Eduroam connectivity guide. Header: &#039;Connect with Eduroam: Secure, Worldwide Access.&#039; Eduroam offers secure, worldwide roaming access for the research and education community. Steps to connect: 1. Open WiFi and click on Eduroam. 2. Select &#039;Don&#039;t validate for CA.&#039; 3. Enter your Prime email ID and password to connect. Benefits: Seamless connectivity, secure, convenient. For help, contact the I.T. Department. Key notes: Use the given Prime email ID on one device at a time, and you cannot change the provided password. Logos of Prime College, Prime Educational Inc., Eduroam, and NREN are at the bottom." decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/07/Eduroam.png 828w, https://prime.edu.np/wp-content/uploads/2024/07/Eduroam-212x300.png 212w, https://prime.edu.np/wp-content/uploads/2024/07/Eduroam-725x1024.png 725w, https://prime.edu.np/wp-content/uploads/2024/07/Eduroam-768x1084.png 768w" sizes="(max-width: 828px) 100vw, 828px" />            </div>
            <div class="card-body">
              <div class="post-date">Aug 1, 2024</div>
              <h4><a href="https://prime.edu.np/event/connect-with-eduroam-secure-worldwide-access/">Connect with Eduroam: Secure, Worldwide Access</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/07/AIT.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="Announcement from Prime College about their partnership with the Asian Institute of Technology (AIT). The image includes logos of both institutions and a handshake graphic. The text mentions that students can now complete joint bachelor&#039;s and master&#039;s programs through this collaboration. Social media icons are displayed at the top right." decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/07/AIT.png 1080w, https://prime.edu.np/wp-content/uploads/2024/07/AIT-300x300.png 300w, https://prime.edu.np/wp-content/uploads/2024/07/AIT-1024x1024.png 1024w, https://prime.edu.np/wp-content/uploads/2024/07/AIT-150x150.png 150w, https://prime.edu.np/wp-content/uploads/2024/07/AIT-768x768.png 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Jul 25, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-college-announces-partnership-with-asian-institute-of-technology-ait/">Prime College Announces Partnership with Asian Institute of Technology (AIT)</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1280" height="1600" src="https://prime.edu.np/wp-content/uploads/2024/07/456241782_17935883315873012_952158015473837324_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/07/456241782_17935883315873012_952158015473837324_n.jpg 1280w, https://prime.edu.np/wp-content/uploads/2024/07/456241782_17935883315873012_952158015473837324_n-240x300.jpg 240w, https://prime.edu.np/wp-content/uploads/2024/07/456241782_17935883315873012_952158015473837324_n-819x1024.jpg 819w, https://prime.edu.np/wp-content/uploads/2024/07/456241782_17935883315873012_952158015473837324_n-768x960.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/07/456241782_17935883315873012_952158015473837324_n-1229x1536.jpg 1229w" sizes="(max-width: 1280px) 100vw, 1280px" />            </div>
            <div class="card-body">
              <div class="post-date">Jul 15, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-college-carnival/">PRIME COLLEGE CARNIVAL 2024 | Prime Flair Club | Prime EMC | Prime E-sports Hub</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2024/06/IMG_3172-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/06/IMG_3172-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2024/06/IMG_3172-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/06/IMG_3172-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/06/IMG_3172-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/06/IMG_3172-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2024/06/IMG_3172-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Jun 21, 2024</div>
              <h4><a href="https://prime.edu.np/event/she-leads-inspiring-journey-of-wonder-women-prime-emc/">Prime College Hosts Empowering Event &#8220;She Leads: Inspiring Journey of Wonder Women&#8221; | Prime EMC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1082" height="907" src="https://prime.edu.np/wp-content/uploads/2024/06/447510715_980431480539790_1140430537823667991_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/06/447510715_980431480539790_1140430537823667991_n.jpg 1082w, https://prime.edu.np/wp-content/uploads/2024/06/447510715_980431480539790_1140430537823667991_n-300x251.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/06/447510715_980431480539790_1140430537823667991_n-1024x858.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/06/447510715_980431480539790_1140430537823667991_n-768x644.jpg 768w" sizes="(max-width: 1082px) 100vw, 1082px" />            </div>
            <div class="card-body">
              <div class="post-date">May 19, 2024</div>
              <h4><a href="https://prime.edu.np/event/game-on-square-prime-sports-club/">Game on Square | Prime Sports Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2048" height="1365" src="https://prime.edu.np/wp-content/uploads/2024/05/443733528_419922677498653_2839625456478159986_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/05/443733528_419922677498653_2839625456478159986_n.jpg 2048w, https://prime.edu.np/wp-content/uploads/2024/05/443733528_419922677498653_2839625456478159986_n-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/05/443733528_419922677498653_2839625456478159986_n-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/05/443733528_419922677498653_2839625456478159986_n-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/05/443733528_419922677498653_2839625456478159986_n-1536x1024.jpg 1536w" sizes="(max-width: 2048px) 100vw, 2048px" />            </div>
            <div class="card-body">
              <div class="post-date">May 13, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-futsal-league-season-2080-81-celebrating-champions-and-sportsmanship/">Prime Futsal League Season 2080/81: Celebrating Champions and Sportsmanship</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2024/05/IMG_0004-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/05/IMG_0004-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2024/05/IMG_0004-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/05/IMG_0004-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/05/IMG_0004-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/05/IMG_0004-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2024/05/IMG_0004-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">May 2, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-bizfest-2024/">Prime Bizfest 2024 | Prime EMCPrime Bizfest 2024: Igniting Entrepreneurial Excellence | Prime EMC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1350" src="https://prime.edu.np/wp-content/uploads/2024/04/440941873_122154184814039650_6995734837840838009_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/04/440941873_122154184814039650_6995734837840838009_n.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/04/440941873_122154184814039650_6995734837840838009_n-240x300.jpg 240w, https://prime.edu.np/wp-content/uploads/2024/04/440941873_122154184814039650_6995734837840838009_n-819x1024.jpg 819w, https://prime.edu.np/wp-content/uploads/2024/04/440941873_122154184814039650_6995734837840838009_n-768x960.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Apr 30, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-fifa-fiesta/">Prime FIFA Fiesta | Prime Esports Hub</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/04/Embracing-change-for-educational-advancement-120778.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/04/Embracing-change-for-educational-advancement-120778.png 1080w, https://prime.edu.np/wp-content/uploads/2024/04/Embracing-change-for-educational-advancement-120778-300x300.png 300w, https://prime.edu.np/wp-content/uploads/2024/04/Embracing-change-for-educational-advancement-120778-1024x1024.png 1024w, https://prime.edu.np/wp-content/uploads/2024/04/Embracing-change-for-educational-advancement-120778-150x150.png 150w, https://prime.edu.np/wp-content/uploads/2024/04/Embracing-change-for-educational-advancement-120778-768x768.png 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Apr 18, 2024</div>
              <h4><a href="https://prime.edu.np/event/embracing-change-for-educational-advancement/">शिक्षामा नवीनता &#8211; “Embracing Change for Educational Advancement&#8221;</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1355" height="1923" src="https://prime.edu.np/wp-content/uploads/2024/03/421221828_8041878555830493_532687142708023032_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/03/421221828_8041878555830493_532687142708023032_n.jpg 1355w, https://prime.edu.np/wp-content/uploads/2024/03/421221828_8041878555830493_532687142708023032_n-211x300.jpg 211w, https://prime.edu.np/wp-content/uploads/2024/03/421221828_8041878555830493_532687142708023032_n-722x1024.jpg 722w, https://prime.edu.np/wp-content/uploads/2024/03/421221828_8041878555830493_532687142708023032_n-768x1090.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/03/421221828_8041878555830493_532687142708023032_n-1082x1536.jpg 1082w" sizes="(max-width: 1355px) 100vw, 1355px" />            </div>
            <div class="card-body">
              <div class="post-date">Mar 31, 2024</div>
              <h4><a href="https://prime.edu.np/event/online-character-certificate-eligibility-and-application-procedure/">Online College Leaving Certificate &#8211; Eligibility and Application Procedure</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2048" height="1365" src="https://prime.edu.np/wp-content/uploads/2024/03/420173062_387030260787895_1599942019332965253_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/03/420173062_387030260787895_1599942019332965253_n.jpg 2048w, https://prime.edu.np/wp-content/uploads/2024/03/420173062_387030260787895_1599942019332965253_n-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/03/420173062_387030260787895_1599942019332965253_n-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/03/420173062_387030260787895_1599942019332965253_n-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/03/420173062_387030260787895_1599942019332965253_n-1536x1024.jpg 1536w" sizes="(max-width: 2048px) 100vw, 2048px" />            </div>
            <div class="card-body">
              <div class="post-date">Mar 20, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-colleges-welcome-farewell-program-2080/">Prime College&#8217;s Welcome Farewell Program 2080</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1600" height="1200" src="https://prime.edu.np/wp-content/uploads/2024/02/image-7.jpeg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/02/image-7.jpeg 1600w, https://prime.edu.np/wp-content/uploads/2024/02/image-7-300x225.jpeg 300w, https://prime.edu.np/wp-content/uploads/2024/02/image-7-1024x768.jpeg 1024w, https://prime.edu.np/wp-content/uploads/2024/02/image-7-768x576.jpeg 768w, https://prime.edu.np/wp-content/uploads/2024/02/image-7-1536x1152.jpeg 1536w" sizes="(max-width: 1600px) 100vw, 1600px" />            </div>
            <div class="card-body">
              <div class="post-date">Feb 21, 2024</div>
              <h4><a href="https://prime.edu.np/event/welcome-to-kathmandu-valley-new-students/">Welcome to Kathmandu Valley, New Students </a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2048" height="1365" src="https://prime.edu.np/wp-content/uploads/2024/01/418973280_775336061290332_5582459766125105047_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/01/418973280_775336061290332_5582459766125105047_n.jpg 2048w, https://prime.edu.np/wp-content/uploads/2024/01/418973280_775336061290332_5582459766125105047_n-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/01/418973280_775336061290332_5582459766125105047_n-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/01/418973280_775336061290332_5582459766125105047_n-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/01/418973280_775336061290332_5582459766125105047_n-1536x1024.jpg 1536w" sizes="(max-width: 2048px) 100vw, 2048px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 31, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-college-unveils-success-of-ict-meetup-v7-0-organized-by-prime-it-club/">Prime College Unveils Success of ICT Meetup V7.0 Organized by Prime IT Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta.jpg 1080w, https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta-768x768.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 24, 2024</div>
              <h4><a href="https://prime.edu.np/event/unveiling-the-exciting-second-edition-of-vrittanta/">Unveiling the Exciting Second Edition of &#8216;Vrittanta:&#8217;</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="810" src="https://prime.edu.np/wp-content/uploads/2024/01/image-1.jpeg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/01/image-1.jpeg 1080w, https://prime.edu.np/wp-content/uploads/2024/01/image-1-300x225.jpeg 300w, https://prime.edu.np/wp-content/uploads/2024/01/image-1-1024x768.jpeg 1024w, https://prime.edu.np/wp-content/uploads/2024/01/image-1-768x576.jpeg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 16, 2024</div>
              <h4><a href="https://prime.edu.np/event/successful-blood-donation-campaign-at-prime-college/">Successful Blood Donation Campaign at Prime College </a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1349" height="1687" src="https://prime.edu.np/wp-content/uploads/2023/12/408990190_18247487419235746_4327342561563846114_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/12/408990190_18247487419235746_4327342561563846114_n.jpg 1349w, https://prime.edu.np/wp-content/uploads/2023/12/408990190_18247487419235746_4327342561563846114_n-240x300.jpg 240w, https://prime.edu.np/wp-content/uploads/2023/12/408990190_18247487419235746_4327342561563846114_n-819x1024.jpg 819w, https://prime.edu.np/wp-content/uploads/2023/12/408990190_18247487419235746_4327342561563846114_n-768x960.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/12/408990190_18247487419235746_4327342561563846114_n-1228x1536.jpg 1228w" sizes="(max-width: 1349px) 100vw, 1349px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 21, 2023</div>
              <h4><a href="https://prime.edu.np/event/prime-it-club-leading-the-way-in-tech-with-ict-meetup-v7-0-prime-college/">Prime IT Club: Leading the Way in Tech with ICT Meetup V7.0 | Prime College</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2023/12/410974671_332859799538275_7898516560910865349_n-1.jpeg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/12/410974671_332859799538275_7898516560910865349_n-1.jpeg 1080w, https://prime.edu.np/wp-content/uploads/2023/12/410974671_332859799538275_7898516560910865349_n-1-300x300.jpeg 300w, https://prime.edu.np/wp-content/uploads/2023/12/410974671_332859799538275_7898516560910865349_n-1-1024x1024.jpeg 1024w, https://prime.edu.np/wp-content/uploads/2023/12/410974671_332859799538275_7898516560910865349_n-1-150x150.jpeg 150w, https://prime.edu.np/wp-content/uploads/2023/12/410974671_332859799538275_7898516560910865349_n-1-768x768.jpeg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 19, 2023</div>
              <h4><a href="https://prime.edu.np/event/introducing-the-executive-board-of-prime-college-alumni-association/">Introducing the Executive Board of Prime College Alumni Association</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/12/PCOP80-350-of-488-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/12/PCOP80-350-of-488-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/12/PCOP80-350-of-488-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/12/PCOP80-350-of-488-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/12/PCOP80-350-of-488-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/12/PCOP80-350-of-488-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/12/PCOP80-350-of-488-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 18, 2023</div>
              <h4><a href="https://prime.edu.np/event/prime-orientation-program-2080-prime-college/">Prime Orientation Program 2080 | Prime College</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1441" src="https://prime.edu.np/wp-content/uploads/2023/12/20231202_152600-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/12/20231202_152600-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/12/20231202_152600-300x169.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/12/20231202_152600-1024x577.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/12/20231202_152600-768x432.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/12/20231202_152600-1536x865.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/12/20231202_152600-2048x1153.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 8, 2023</div>
              <h4><a href="https://prime.edu.np/event/prime-colleges-first-ever-inter-student-club-futsal/">Prime College&#8217;s First-Ever Inter-Student Club Futsal </a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/12/PCPAD-168-of-286-1-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/12/PCPAD-168-of-286-1-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/12/PCPAD-168-of-286-1-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/12/PCPAD-168-of-286-1-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/12/PCPAD-168-of-286-1-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/12/PCPAD-168-of-286-1-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/12/PCPAD-168-of-286-1-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 3, 2023</div>
              <h4><a href="https://prime.edu.np/event/prime-alumni-dinner-prime-college/">Prime Alumni Dinner 2080 | Prime College</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta.jpg 1080w, https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta-768x768.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 20, 2023</div>
              <h4><a href="https://prime.edu.np/event/vrittanta-unveiling-our-quarterly-newsletter/">Vrittanta: Unveiling Our Quarterly Newsletter</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="999" height="749" src="https://prime.edu.np/wp-content/uploads/2023/10/image-38.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/10/image-38.png 999w, https://prime.edu.np/wp-content/uploads/2023/10/image-38-300x225.png 300w, https://prime.edu.np/wp-content/uploads/2023/10/image-38-768x576.png 768w" sizes="(max-width: 999px) 100vw, 999px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 20, 2023</div>
              <h4><a href="https://prime.edu.np/event/industrial-visit-to-barahsinghe-yak-brewery-bim-2019/">Industrial Visit to Barahsinghe – Yak Brewery | BIM 2019</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1440" height="960" src="https://prime.edu.np/wp-content/uploads/2023/10/391616941_18209565001261107_4185982729490321527_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/10/391616941_18209565001261107_4185982729490321527_n.jpg 1440w, https://prime.edu.np/wp-content/uploads/2023/10/391616941_18209565001261107_4185982729490321527_n-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/10/391616941_18209565001261107_4185982729490321527_n-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/10/391616941_18209565001261107_4185982729490321527_n-768x512.jpg 768w" sizes="(max-width: 1440px) 100vw, 1440px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 19, 2023</div>
              <h4><a href="https://prime.edu.np/event/dashain-celebration-at-prime-college-prime-cultural-club/">Dashain Celebration at Prime College | Prime Cultural Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/10/PCEN-196-of-439-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/10/PCEN-196-of-439-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/10/PCEN-196-of-439-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/10/PCEN-196-of-439-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/10/PCEN-196-of-439-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/10/PCEN-196-of-439-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/10/PCEN-196-of-439-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 9, 2023</div>
              <h4><a href="https://prime.edu.np/event/club-executive-night/">Prime Club Executive Night: Building Connections for the Future</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/07/PCR-293-of-372-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/PCR-293-of-372-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/07/PCR-293-of-372-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/07/PCR-293-of-372-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/PCR-293-of-372-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/07/PCR-293-of-372-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/07/PCR-293-of-372-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Sep 24, 2023</div>
              <h4><a href="https://prime.edu.np/event/club-reformation/">Student Club Reformation: Celebrating Leadership and Achievements</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/07/AYU_1907_pp-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/AYU_1907_pp-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/07/AYU_1907_pp-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/07/AYU_1907_pp-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/AYU_1907_pp-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/07/AYU_1907_pp-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/07/AYU_1907_pp-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Sep 13, 2023</div>
              <h4><a href="https://prime.edu.np/event/admission-open/">Admission Open for Bachelor Program at Prime College</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1440" height="960" src="https://prime.edu.np/wp-content/uploads/2023/07/375042453_615840130733730_5422038540697253480_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/375042453_615840130733730_5422038540697253480_n.jpg 1440w, https://prime.edu.np/wp-content/uploads/2023/07/375042453_615840130733730_5422038540697253480_n-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/07/375042453_615840130733730_5422038540697253480_n-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/375042453_615840130733730_5422038540697253480_n-768x512.jpg 768w" sizes="(max-width: 1440px) 100vw, 1440px" />            </div>
            <div class="card-body">
              <div class="post-date">Sep 2, 2023</div>
              <h4><a href="https://prime.edu.np/event/prime_bizfest/">Prime BizFest 2023 at Prime College | Prime EMC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1710" src="https://prime.edu.np/wp-content/uploads/2023/07/DSC01168-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/DSC01168-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/07/DSC01168-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/07/DSC01168-1024x684.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/DSC01168-768x513.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/07/DSC01168-1536x1026.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/07/DSC01168-2048x1368.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Aug 26, 2023</div>
              <h4><a href="https://prime.edu.np/event/sukul_session_vol_2/">Sukul Session Vol. 2 | Prime Flair Hub</a></h4>
            </div>
          </div>
        </div>
              </div>
    </div>
  </div>
</div>
<!-- End News And Event -->


<!-- Start News And Event -->
<div class="news-event block pb-0">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="section-head">
          <div class="d-sm-flex justify-content-between">
            <p>Upcoming Events</p>
            <a href="https://prime.edu.np/events/" class="link">View All</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="news-event-area">
    <!-- Slider main container -->
    <div class="swiper news-event-slider">
      <!-- Additional required wrapper -->
      <div class="swiper-wrapper">
        <!-- Slides -->
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1350" src="https://prime.edu.np/wp-content/uploads/2025/01/WF_SMP_Final.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2025/01/WF_SMP_Final.png 1080w, https://prime.edu.np/wp-content/uploads/2025/01/WF_SMP_Final-240x300.png 240w, https://prime.edu.np/wp-content/uploads/2025/01/WF_SMP_Final-819x1024.png 819w, https://prime.edu.np/wp-content/uploads/2025/01/WF_SMP_Final-768x960.png 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 5, 2025</div>
              <h4><a href="https://prime.edu.np/event/welcome-and-farewell-2081/">Welcome &amp; Farewell Program 2081</a></h4>
            </div>
          </div>
        </div>
                 <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/07/blue-promotion-schedule-instagram-post-design.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="Prime College Seminar Hall and Multipurpose Room Schedule. The image features the Prime College logo at the top, with the text &#039;Seminar Hall &amp; Multipurpose Room Schedule&#039; beneath it. Below the text is an illustration of a calendar with a few dates highlighted, signifying the schedule." decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/07/blue-promotion-schedule-instagram-post-design.png 1080w, https://prime.edu.np/wp-content/uploads/2024/07/blue-promotion-schedule-instagram-post-design-300x300.png 300w, https://prime.edu.np/wp-content/uploads/2024/07/blue-promotion-schedule-instagram-post-design-1024x1024.png 1024w, https://prime.edu.np/wp-content/uploads/2024/07/blue-promotion-schedule-instagram-post-design-150x150.png 150w, https://prime.edu.np/wp-content/uploads/2024/07/blue-promotion-schedule-instagram-post-design-768x768.png 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Jul 28, 2024</div>
              <h4><a href="https://prime.edu.np/event/upcoming-events-seminar-hall-multipurpose-room-schedule/">Upcoming Events: Seminar Hall &amp; Multipurpose Room Schedule</a></h4>
            </div>
          </div>
        </div>
               </div>
    </div>
  </div>
</div>
<!-- End News And Event -->

<!--Start Notice Section-->
<div class="notice-section block pb-0 d-none">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="section-head mb-5">
          <h2 class="section-title">Notices</h2>
        </div>
      </div>
    </div>
    <div class="row g-4 justify-content-around">
                <div class="col-sm-12 col-md-4 col-lg-4">
            <div class="notice-item equal-height">
                
                        <h4><a href="https://prime.edu.np/wp-content/uploads/2024/03/Dress-Code-Guidelines.jpg" class="fancybox" data-fancybox="images-preview">Dress Code Guidelines</a></h4>
                        <p class="mb-0">Mar 29, 2024</p>
                    
                        <a href="https://prime.edu.np/wp-content/uploads/2024/03/Dress-Code-Guidelines.jpg" class="view-link" data-fancybox="images-preview">View Detail</a>
                  
                
            </div>
        </div>
                <div class="col-sm-12 col-md-4 col-lg-4">
            <div class="notice-item equal-height">
                
                        <h4><a href="https://prime.edu.np/wp-content/uploads/2024/03/421221828_8041878555830493_532687142708023032_n.jpg" class="fancybox" data-fancybox="images-preview">Online College Leaving Certificate</a></h4>
                        <p class="mb-0">Mar 31, 2024</p>
                    
                        <a href="https://prime.edu.np/wp-content/uploads/2024/03/421221828_8041878555830493_532687142708023032_n.jpg" class="view-link" data-fancybox="images-preview">View Detail</a>
                  
                
            </div>
        </div>
                <div class="col-sm-12 col-md-4 col-lg-4">
            <div class="notice-item equal-height">
                
                        <h4><a href="https://prime.edu.np/wp-content/uploads/2024/04/Financial-Literacy-Session-scaled.jpg" class="fancybox" data-fancybox="images-preview">Notice to BBA/BIM/BBM Students &#8211; Financial Literacy Session</a></h4>
                        <p class="mb-0">Apr 1, 2024</p>
                    
                        <a href="https://prime.edu.np/wp-content/uploads/2024/04/Financial-Literacy-Session-scaled.jpg" class="view-link" data-fancybox="images-preview">View Detail</a>
                  
                
            </div>
        </div>
            </div>
              <div class="mt-4 text-center">
      <a href="https://prime.edu.np/notices" class="btn btn-primary">See All Notices</a>
  </div>
    </div>
    </div>
<!--End Notice Section-->

<!--Start Prime Blog-->
<div class="prime-blog-section block pb-0">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-head">
                    <h3 class="section-title">
                        <a href="https://prime.edu.np/prime-blog" class="text-primary">Prime Blogs</a>
                    </h3>
                </div>
            </div>
        </div>
    </div>
      <div class="news-event-area">
    <!-- Slider main container -->
    <div class="swiper news-event-slider">
      <!-- Additional required wrapper -->
      <div class="swiper-wrapper">
        <!-- Slides -->
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1600" height="1200" src="https://prime.edu.np/wp-content/uploads/2024/12/IMG-20240207-WA0024.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/IMG-20240207-WA0024.jpg 1600w, https://prime.edu.np/wp-content/uploads/2024/12/IMG-20240207-WA0024-300x225.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/12/IMG-20240207-WA0024-1024x768.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/12/IMG-20240207-WA0024-768x576.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/12/IMG-20240207-WA0024-1536x1152.jpg 1536w" sizes="(max-width: 1600px) 100vw, 1600px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 13, 2025</div>
              <h4><a href="https://prime.edu.np/prime_blog/reflections-of-leadership-my-journey-as-president-of-prime-sports-club-prabin-lama-bba-2076-batch/">Reflections of Leadership: My Journey as President of Prime Sports Club | Prabin Lama, BBA  2076 Batch</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1920" src="https://prime.edu.np/wp-content/uploads/2025/01/IMG20250104122923-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2025/01/IMG20250104122923-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2025/01/IMG20250104122923-300x225.jpg 300w, https://prime.edu.np/wp-content/uploads/2025/01/IMG20250104122923-1024x768.jpg 1024w, https://prime.edu.np/wp-content/uploads/2025/01/IMG20250104122923-768x576.jpg 768w, https://prime.edu.np/wp-content/uploads/2025/01/IMG20250104122923-1536x1152.jpg 1536w, https://prime.edu.np/wp-content/uploads/2025/01/IMG20250104122923-2048x1536.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 10, 2025</div>
              <h4><a href="https://prime.edu.np/prime_blog/exploring-connections-a-reflective-journey-to-jamacho-niraj-thapa-magar-mlrc-coordinator/">Exploring Connections: A Reflective Journey to Jamacho | Niraj Thapa Magar, MLRC Coordinator</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1440" height="960" src="https://prime.edu.np/wp-content/uploads/2025/01/472036882_17951888546873012_2150606352062312944_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2025/01/472036882_17951888546873012_2150606352062312944_n.jpg 1440w, https://prime.edu.np/wp-content/uploads/2025/01/472036882_17951888546873012_2150606352062312944_n-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2025/01/472036882_17951888546873012_2150606352062312944_n-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2025/01/472036882_17951888546873012_2150606352062312944_n-768x512.jpg 768w" sizes="(max-width: 1440px) 100vw, 1440px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 5, 2025</div>
              <h4><a href="https://prime.edu.np/prime_blog/ink-and-imagination-vol-2-prime-flair-club/">Ink and Imagination Vol. 2 | Prime Flair Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1624" src="https://prime.edu.np/wp-content/uploads/2024/12/Screenshot_20241227_134346_Instagram-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/Screenshot_20241227_134346_Instagram-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2024/12/Screenshot_20241227_134346_Instagram-300x190.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/12/Screenshot_20241227_134346_Instagram-1024x650.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/12/Screenshot_20241227_134346_Instagram-768x487.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/12/Screenshot_20241227_134346_Instagram-1536x975.jpg 1536w, https://prime.edu.np/wp-content/uploads/2024/12/Screenshot_20241227_134346_Instagram-2048x1300.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 1, 2025</div>
              <h4><a href="https://prime.edu.np/prime_blog/leading-with-heart-my-journey-as-president-of-prime-cultural-club-yuki-maharjan-bba-2076-batch/">Leading with Heart: My Journey as President of Prime Cultural Club | Yuki Maharjan, BBA 2076 Batch</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2016" height="1512" src="https://prime.edu.np/wp-content/uploads/2024/12/Received-Image-from-Rudeshman.jpeg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/Received-Image-from-Rudeshman.jpeg 2016w, https://prime.edu.np/wp-content/uploads/2024/12/Received-Image-from-Rudeshman-300x225.jpeg 300w, https://prime.edu.np/wp-content/uploads/2024/12/Received-Image-from-Rudeshman-1024x768.jpeg 1024w, https://prime.edu.np/wp-content/uploads/2024/12/Received-Image-from-Rudeshman-768x576.jpeg 768w, https://prime.edu.np/wp-content/uploads/2024/12/Received-Image-from-Rudeshman-1536x1152.jpeg 1536w" sizes="(max-width: 2016px) 100vw, 2016px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 22, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/rudesh-manandhar-leading-with-vision-my-journey-with-the-prime-flair-club-bsc-csit-2076-batch/">Rudesh Manandhar: Leading with Vision &#8211; My Journey with the Prime Flair Club | BSc. CSIT 2076 Batch</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1284" height="846" src="https://prime.edu.np/wp-content/uploads/2024/12/Inaugration_speech_for_ICT_Meetup.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/Inaugration_speech_for_ICT_Meetup.jpg 1284w, https://prime.edu.np/wp-content/uploads/2024/12/Inaugration_speech_for_ICT_Meetup-300x198.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/12/Inaugration_speech_for_ICT_Meetup-1024x675.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/12/Inaugration_speech_for_ICT_Meetup-768x506.jpg 768w" sizes="(max-width: 1284px) 100vw, 1284px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 20, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/supriya-thapa-bhujel-my-journey-leading-the-prime-it-club-bsc-csit-2076-batch/">Supriya Thapa Bhujel: My Journey Leading the Prime IT Club | BSc. CSIT 2076 Batch</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1280" height="960" src="https://prime.edu.np/wp-content/uploads/2024/12/470001839_561078000049786_629480348383715967_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/470001839_561078000049786_629480348383715967_n.jpg 1280w, https://prime.edu.np/wp-content/uploads/2024/12/470001839_561078000049786_629480348383715967_n-300x225.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/12/470001839_561078000049786_629480348383715967_n-1024x768.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/12/470001839_561078000049786_629480348383715967_n-768x576.jpg 768w" sizes="(max-width: 1280px) 100vw, 1280px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 18, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/21st-prime-sports-gala-2081-a-celebration-of-talent-teamwork-and-triumph/">21st Prime Sports Gala 2081: A Celebration of Talent, Teamwork, and Triumph </a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="798" height="600" src="https://prime.edu.np/wp-content/uploads/2024/11/original-121D23B7-3D27-4F38-B52A-A2011C67AC3B.jpeg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/11/original-121D23B7-3D27-4F38-B52A-A2011C67AC3B.jpeg 798w, https://prime.edu.np/wp-content/uploads/2024/11/original-121D23B7-3D27-4F38-B52A-A2011C67AC3B-300x226.jpeg 300w, https://prime.edu.np/wp-content/uploads/2024/11/original-121D23B7-3D27-4F38-B52A-A2011C67AC3B-768x577.jpeg 768w" sizes="(max-width: 798px) 100vw, 798px" />            </div>
            <div class="card-body">
              <div class="post-date">Nov 6, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/my-journey-as-the-president-of-prime-emc-prabesh-adhikari-bsc-csit-2076-batch/">My Journey as the President of Prime EMC | Prabesh Adhikari, BSc. CSIT 2076 Batch </a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2024/10/1001053618-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/10/1001053618-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2024/10/1001053618-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/10/1001053618-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/10/1001053618-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/10/1001053618-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2024/10/1001053618-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 1, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/my-journey-of-growth-and-unforgettable-memories-at-prime-college-angelique-dangol-bbm-2076-batch/">My Journey of Growth and Unforgettable Memories at Prime College | Angelique Dangol, BBM 2076 Batch</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="720" src="https://prime.edu.np/wp-content/uploads/2024/09/IMG-20240909-WA0009.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/09/IMG-20240909-WA0009.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/09/IMG-20240909-WA0009-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/09/IMG-20240909-WA0009-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/09/IMG-20240909-WA0009-768x512.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Sep 20, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/my-experience-at-prime-it-club-jenish-maharjan-bca-2076-batch/">My Experience at Prime IT Club | Jenish Maharjan, BCA 2076 Batch</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="620" height="480" src="https://prime.edu.np/wp-content/uploads/2024/09/Picture.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/09/Picture.jpg 620w, https://prime.edu.np/wp-content/uploads/2024/09/Picture-300x232.jpg 300w" sizes="(max-width: 620px) 100vw, 620px" />            </div>
            <div class="card-body">
              <div class="post-date">Sep 5, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/reflections-on-my-journey-at-prime-college-smriti-maharjan-bba-2076-batch/">Reflections on My Journey at Prime College | Smriti Maharjan, BBA 2076 Batch</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="468" height="351" src="https://prime.edu.np/wp-content/uploads/2024/08/e1.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/08/e1.jpg 468w, https://prime.edu.np/wp-content/uploads/2024/08/e1-300x225.jpg 300w" sizes="(max-width: 468px) 100vw, 468px" />            </div>
            <div class="card-body">
              <div class="post-date">Aug 30, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/this-experience-at-prime-college-was-a-game-changer-for-me-pushpa-kc-bba-2076-batch/">This experience at Prime College was a game-changer for me | Pushpa KC, BBA 2076 batch</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1800" height="1350" src="https://prime.edu.np/wp-content/uploads/2024/08/Water-distribution.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/08/Water-distribution.jpg 1800w, https://prime.edu.np/wp-content/uploads/2024/08/Water-distribution-300x225.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/08/Water-distribution-1024x768.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/08/Water-distribution-768x576.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/08/Water-distribution-1536x1152.jpg 1536w" sizes="(max-width: 1800px) 100vw, 1800px" />            </div>
            <div class="card-body">
              <div class="post-date">Aug 25, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/water-distribution-on-gunla-prime-cultural-club-and-prime-sic/">Water Distribution on Gunla | Prime Cultural Club and Prime SIC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1600" height="1200" src="https://prime.edu.np/wp-content/uploads/2024/08/WhatsApp-Image-2024-08-09-at-12.54.40 PM-1.jpeg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/08/WhatsApp-Image-2024-08-09-at-12.54.40 PM-1.jpeg 1600w, https://prime.edu.np/wp-content/uploads/2024/08/WhatsApp-Image-2024-08-09-at-12.54.40 PM-1-300x225.jpeg 300w, https://prime.edu.np/wp-content/uploads/2024/08/WhatsApp-Image-2024-08-09-at-12.54.40 PM-1-1024x768.jpeg 1024w, https://prime.edu.np/wp-content/uploads/2024/08/WhatsApp-Image-2024-08-09-at-12.54.40 PM-1-768x576.jpeg 768w, https://prime.edu.np/wp-content/uploads/2024/08/WhatsApp-Image-2024-08-09-at-12.54.40 PM-1-1536x1152.jpeg 1536w" sizes="(max-width: 1600px) 100vw, 1600px" />            </div>
            <div class="card-body">
              <div class="post-date">Aug 12, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/environmental-social-and-governance-esg-workshop-mlrc/">Environmental, Social, and Governance (ESG) Workshop | MLRC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="728" height="408" src="https://prime.edu.np/wp-content/uploads/2024/07/elegant-bridal-hands-stockcake.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/07/elegant-bridal-hands-stockcake.jpg 728w, https://prime.edu.np/wp-content/uploads/2024/07/elegant-bridal-hands-stockcake-300x168.jpg 300w" sizes="(max-width: 728px) 100vw, 728px" />            </div>
            <div class="card-body">
              <div class="post-date">Jul 7, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/rendezvous-sadikshya-sherchan-bba/">Rendezvous | Sadikshya Sherchan, BBA</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="957" height="1440" src="https://prime.edu.np/wp-content/uploads/2024/06/Snapchat-2133473591.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/06/Snapchat-2133473591.jpg 957w, https://prime.edu.np/wp-content/uploads/2024/06/Snapchat-2133473591-199x300.jpg 199w, https://prime.edu.np/wp-content/uploads/2024/06/Snapchat-2133473591-681x1024.jpg 681w, https://prime.edu.np/wp-content/uploads/2024/06/Snapchat-2133473591-768x1156.jpg 768w" sizes="(max-width: 957px) 100vw, 957px" />            </div>
            <div class="card-body">
              <div class="post-date">Jun 28, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/times-torment-ismail-ahmad-bim/">Time’s Torment | Smile Ahmed, BIM</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2047" height="1536" src="https://prime.edu.np/wp-content/uploads/2024/06/a1.jpeg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/06/a1.jpeg 2047w, https://prime.edu.np/wp-content/uploads/2024/06/a1-300x225.jpeg 300w, https://prime.edu.np/wp-content/uploads/2024/06/a1-1024x768.jpeg 1024w, https://prime.edu.np/wp-content/uploads/2024/06/a1-768x576.jpeg 768w, https://prime.edu.np/wp-content/uploads/2024/06/a1-1536x1153.jpeg 1536w" sizes="(max-width: 2047px) 100vw, 2047px" />            </div>
            <div class="card-body">
              <div class="post-date">Jun 28, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/cybersecurity-awareness-program-aavash-devkota-bsc-csit/">Cybersecurity Awareness Program | Aavash Devkota, BSc. CSIT</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1536" height="1536" src="https://prime.edu.np/wp-content/uploads/2024/06/Last-Day-1.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/06/Last-Day-1.jpg 1536w, https://prime.edu.np/wp-content/uploads/2024/06/Last-Day-1-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/06/Last-Day-1-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/06/Last-Day-1-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2024/06/Last-Day-1-768x768.jpg 768w" sizes="(max-width: 1536px) 100vw, 1536px" />            </div>
            <div class="card-body">
              <div class="post-date">Jun 25, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/emotional-intelligence-and-self-discovery-journey-through-a-workshop-experience-sumina-maharjan/">Emotional intelligence and self-discovery journey through a workshop experience | Sumina Maharjan</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1348" height="1011" src="https://prime.edu.np/wp-content/uploads/2024/05/8s02ck17WzKpZVRpFtiD2Fkglav6WArHLf5H5Y6e.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/05/8s02ck17WzKpZVRpFtiD2Fkglav6WArHLf5H5Y6e.jpg 1348w, https://prime.edu.np/wp-content/uploads/2024/05/8s02ck17WzKpZVRpFtiD2Fkglav6WArHLf5H5Y6e-300x225.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/05/8s02ck17WzKpZVRpFtiD2Fkglav6WArHLf5H5Y6e-1024x768.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/05/8s02ck17WzKpZVRpFtiD2Fkglav6WArHLf5H5Y6e-768x576.jpg 768w" sizes="(max-width: 1348px) 100vw, 1348px" />            </div>
            <div class="card-body">
              <div class="post-date">May 30, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/empowering-girls-through-tech-the-ms-office-workshop-journey-niva-maharjan-prime-it-club/">Empowering Girls through Tech: The MS Office Workshop Journey | Niva Maharjan | Prime IT Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1600" height="1200" src="https://prime.edu.np/wp-content/uploads/2024/02/durga-4.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/02/durga-4.jpg 1600w, https://prime.edu.np/wp-content/uploads/2024/02/durga-4-300x225.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/02/durga-4-1024x768.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/02/durga-4-768x576.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/02/durga-4-1536x1152.jpg 1536w" sizes="(max-width: 1600px) 100vw, 1600px" />            </div>
            <div class="card-body">
              <div class="post-date">Feb 15, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/a-day-out-with-prime-family-durga-thapa/">A day out with Prime Family | Durga Thapa</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2048" height="1146" src="https://prime.edu.np/wp-content/uploads/2024/02/425003817_359838886840366_5266617936931921540_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/02/425003817_359838886840366_5266617936931921540_n.jpg 2048w, https://prime.edu.np/wp-content/uploads/2024/02/425003817_359838886840366_5266617936931921540_n-300x168.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/02/425003817_359838886840366_5266617936931921540_n-1024x573.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/02/425003817_359838886840366_5266617936931921540_n-768x430.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/02/425003817_359838886840366_5266617936931921540_n-1536x860.jpg 1536w" sizes="(max-width: 2048px) 100vw, 2048px" />            </div>
            <div class="card-body">
              <div class="post-date">Feb 13, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/prime-inter-college-student-club-meet-up-fostering-collaboration-and-community-building-among-student-community-mlrc/">Fostering Collaboration and Community Building Among Student Community | MLRC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/02/415447653_838297254972661_6869031890492629374_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/02/415447653_838297254972661_6869031890492629374_n.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/02/415447653_838297254972661_6869031890492629374_n-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/02/415447653_838297254972661_6869031890492629374_n-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/02/415447653_838297254972661_6869031890492629374_n-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2024/02/415447653_838297254972661_6869031890492629374_n-768x768.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Feb 12, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/spreading-joy-a-recap-of-the-smile-for-all-christmas-event-mlrc/">Spreading Joy: A Recap of the Smile for All-Christmas Event | MLRC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1351" src="https://prime.edu.np/wp-content/uploads/2024/02/martin-1.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/02/martin-1.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/02/martin-1-240x300.jpg 240w, https://prime.edu.np/wp-content/uploads/2024/02/martin-1-819x1024.jpg 819w, https://prime.edu.np/wp-content/uploads/2024/02/martin-1-768x961.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Feb 11, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/music-for-cause-vol-ii-a-harmonious-journey-of-giving-back-mlrc/">Music For Cause Vol-II: A Harmonious Journey of Giving Back | MLRC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1600" height="1200" src="https://prime.edu.np/wp-content/uploads/2024/01/0-02-03-f43e114833019193195e84679d12f6aa8e963265ce6bf9326799b97b6fe27d9c_b8cc2f06ead43179.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/01/0-02-03-f43e114833019193195e84679d12f6aa8e963265ce6bf9326799b97b6fe27d9c_b8cc2f06ead43179.jpg 1600w, https://prime.edu.np/wp-content/uploads/2024/01/0-02-03-f43e114833019193195e84679d12f6aa8e963265ce6bf9326799b97b6fe27d9c_b8cc2f06ead43179-300x225.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/01/0-02-03-f43e114833019193195e84679d12f6aa8e963265ce6bf9326799b97b6fe27d9c_b8cc2f06ead43179-1024x768.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/01/0-02-03-f43e114833019193195e84679d12f6aa8e963265ce6bf9326799b97b6fe27d9c_b8cc2f06ead43179-768x576.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/01/0-02-03-f43e114833019193195e84679d12f6aa8e963265ce6bf9326799b97b6fe27d9c_b8cc2f06ead43179-1536x1152.jpg 1536w" sizes="(max-width: 1600px) 100vw, 1600px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 19, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/prime-picnic-program-at-switzerland-park-rina-chakubaji/">Prime Picnic Program at Switzerland Park | Rina Chakubaji</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2048" height="1536" src="https://prime.edu.np/wp-content/uploads/2024/01/417106697_1094830374981258_6512159591985763915_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/01/417106697_1094830374981258_6512159591985763915_n.jpg 2048w, https://prime.edu.np/wp-content/uploads/2024/01/417106697_1094830374981258_6512159591985763915_n-300x225.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/01/417106697_1094830374981258_6512159591985763915_n-1024x768.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/01/417106697_1094830374981258_6512159591985763915_n-768x576.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/01/417106697_1094830374981258_6512159591985763915_n-1536x1152.jpg 1536w" sizes="(max-width: 2048px) 100vw, 2048px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 18, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/a-memorable-getaway-to-chitlang-samyukta-silakar/">A Memorable Getaway to Chitlang | Samyukta Silakar</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2024/01/81e979a2-3719-4b48-997a-54a76487001c-scaled.jpeg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/01/81e979a2-3719-4b48-997a-54a76487001c-scaled.jpeg 2560w, https://prime.edu.np/wp-content/uploads/2024/01/81e979a2-3719-4b48-997a-54a76487001c-300x200.jpeg 300w, https://prime.edu.np/wp-content/uploads/2024/01/81e979a2-3719-4b48-997a-54a76487001c-1024x683.jpeg 1024w, https://prime.edu.np/wp-content/uploads/2024/01/81e979a2-3719-4b48-997a-54a76487001c-768x512.jpeg 768w, https://prime.edu.np/wp-content/uploads/2024/01/81e979a2-3719-4b48-997a-54a76487001c-1536x1024.jpeg 1536w, https://prime.edu.np/wp-content/uploads/2024/01/81e979a2-3719-4b48-997a-54a76487001c-2048x1365.jpeg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 17, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/prime-college-experiences-and-lessons/">Prime College: Experiences and Lessons | Minasha Maharjan</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1440" height="810" src="https://prime.edu.np/wp-content/uploads/2023/12/370781894_704084008428820_884519767836668513_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/12/370781894_704084008428820_884519767836668513_n.jpg 1440w, https://prime.edu.np/wp-content/uploads/2023/12/370781894_704084008428820_884519767836668513_n-300x169.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/12/370781894_704084008428820_884519767836668513_n-1024x576.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/12/370781894_704084008428820_884519767836668513_n-768x432.jpg 768w" sizes="(max-width: 1440px) 100vw, 1440px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 12, 2023</div>
              <h4><a href="https://prime.edu.np/prime_blog/harmony-in-diversity-neeti-tamrakars-journey-with-prime-cultural-club/">Harmony in Diversity: Neeti Tamrakar&#8217;s Journey with Prime Cultural Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="999" height="666" src="https://prime.edu.np/wp-content/uploads/2023/10/image-31.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/10/image-31.png 999w, https://prime.edu.np/wp-content/uploads/2023/10/image-31-300x200.png 300w, https://prime.edu.np/wp-content/uploads/2023/10/image-31-768x512.png 768w" sizes="(max-width: 999px) 100vw, 999px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 16, 2023</div>
              <h4><a href="https://prime.edu.np/prime_blog/my-leadership-journey-at-prime-emc-a-year-of-growth-and-impact/">My Leadership Journey at Prime EMC: A Year of Growth and Impact | Swastika Banskota</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2048" height="1536" src="https://prime.edu.np/wp-content/uploads/2023/10/361607899_665423745614898_221608660978922055_n-1.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/10/361607899_665423745614898_221608660978922055_n-1.jpg 2048w, https://prime.edu.np/wp-content/uploads/2023/10/361607899_665423745614898_221608660978922055_n-1-300x225.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/10/361607899_665423745614898_221608660978922055_n-1-1024x768.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/10/361607899_665423745614898_221608660978922055_n-1-768x576.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/10/361607899_665423745614898_221608660978922055_n-1-1536x1152.jpg 1536w" sizes="(max-width: 2048px) 100vw, 2048px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 11, 2023</div>
              <h4><a href="https://prime.edu.np/prime_blog/unveiling-the-leadership-journey-of-pramila-shrestha/">Unveiling the Leadership Journey of Pramila Shrestha, President of Prime IT Club (2022-2023) | Niraj Thapa Magar</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="999" height="562" src="https://prime.edu.np/wp-content/uploads/2023/10/image-1.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/10/image-1.png 999w, https://prime.edu.np/wp-content/uploads/2023/10/image-1-300x169.png 300w, https://prime.edu.np/wp-content/uploads/2023/10/image-1-768x432.png 768w" sizes="(max-width: 999px) 100vw, 999px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 9, 2023</div>
              <h4><a href="https://prime.edu.np/prime_blog/bba-7th-semesters-sustainable-city-project/">BBA 7th Semester&#8217;s Sustainable City Project | Niraj Thapa Magar</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1192" height="810" src="https://prime.edu.np/wp-content/uploads/2023/09/kathmandu-milk.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/09/kathmandu-milk.png 1192w, https://prime.edu.np/wp-content/uploads/2023/09/kathmandu-milk-300x204.png 300w, https://prime.edu.np/wp-content/uploads/2023/09/kathmandu-milk-1024x696.png 1024w, https://prime.edu.np/wp-content/uploads/2023/09/kathmandu-milk-768x522.png 768w" sizes="(max-width: 1192px) 100vw, 1192px" />            </div>
            <div class="card-body">
              <div class="post-date">Sep 5, 2023</div>
              <h4><a href="https://prime.edu.np/prime_blog/debunking-the-myth-unveiling-the-truth-about-packaged-milk/">Debunking the Myth: Unveiling the Truth about Packaged Milk | Niraj Thapa Magar</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="326" height="254" src="https://prime.edu.np/wp-content/uploads/2023/12/image-9.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/12/image-9.png 326w, https://prime.edu.np/wp-content/uploads/2023/12/image-9-300x234.png 300w" sizes="(max-width: 326px) 100vw, 326px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 15, 2022</div>
              <h4><a href="https://prime.edu.np/prime_blog/internship-at-prime-college-juneli-sunar/">Internship At Prime College | Juneli Sunar</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1604" height="2560" src="https://prime.edu.np/wp-content/uploads/2023/12/You-are-Beautiful-scaled.jpeg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/12/You-are-Beautiful-scaled.jpeg 1604w, https://prime.edu.np/wp-content/uploads/2023/12/You-are-Beautiful-188x300.jpeg 188w, https://prime.edu.np/wp-content/uploads/2023/12/You-are-Beautiful-642x1024.jpeg 642w, https://prime.edu.np/wp-content/uploads/2023/12/You-are-Beautiful-768x1225.jpeg 768w, https://prime.edu.np/wp-content/uploads/2023/12/You-are-Beautiful-963x1536.jpeg 963w, https://prime.edu.np/wp-content/uploads/2023/12/You-are-Beautiful-1283x2048.jpeg 1283w" sizes="(max-width: 1604px) 100vw, 1604px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 31, 2022</div>
              <h4><a href="https://prime.edu.np/prime_blog/you-are-beautiful-swastika-banskota/">You Are Beautiful | Swastika Banskota</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1024" height="577" src="https://prime.edu.np/wp-content/uploads/2023/10/159865420_3667208353348504_2712345859807409217_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/10/159865420_3667208353348504_2712345859807409217_n.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/10/159865420_3667208353348504_2712345859807409217_n-300x169.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/10/159865420_3667208353348504_2712345859807409217_n-768x433.jpg 768w" sizes="(max-width: 1024px) 100vw, 1024px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 20, 2022</div>
              <h4><a href="https://prime.edu.np/prime_blog/actual-diary-never-to-forget-juneli-sunar/">Actual Diary Never to Forget | Juneli Sunar</a></h4>
            </div>
          </div>
        </div>
              </div>
    </div>
  </div>
    <div class="mt-4 text-center">
      <a href="https://prime.edu.np/prime-blog" class="btn btn-primary">See All Blogs</a>
  </div>
</div>
<!--End Prime Blog-->



<!-- Start Our Partner -->
<div class="our-Partner-section block">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="section-head">
          <h2 class="section-title text-center">
           Our Partners          </h2>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <ul class="nav nav-pills" id="pills-tab" role="tablist">
          <li class="nav-item" role="presentation">
            <button class="nav-link active" id="pills-home-tab" data-bs-toggle="pill" data-bs-target="#pills-home" type="button" role="tab" aria-controls="pills-home" aria-selected="true">Prime Privilege Partner</button>
          </li>
          <li class="nav-item" role="presentation">
            <button class="nav-link" id="pills-profile-tab" data-bs-toggle="pill" data-bs-target="#pills-profile" type="button" role="tab" aria-controls="pills-profile" aria-selected="false">Prime Career Partner</button>
          </li>
          <li class="nav-item" role="presentation">
            <button class="nav-link" id="pills-contact-tab" data-bs-toggle="pill" data-bs-target="#pills-contact" type="button" role="tab" aria-controls="pills-contact" aria-selected="false">Prime Worldwide Partner</button>
          </li>
        </ul>
        <div class="tab-content" id="pills-tabContent">
          <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab" tabindex="0">
              <div class="swiper partner-slider">
  <!-- Additional required wrapper -->
  <div class="swiper-wrapper">
    <!-- Slides -->
                  <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/07/cafenlava.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/07/morison.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/08/logo.png" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/07/mlight.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/07/wdn.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/08/350.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/08/The-Dairy-Station-Logo.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/08/washmandu.png" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/08/sowa.png" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/08/bluec.png" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/09/kpl.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/07/beernnuts.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/08/studio.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/08/Be-Legend-Shapes-Gym-Logo-scaled.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/08/Devi-Chandima-Electronics-Vector-Image.png" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2024/05/Bo-Bo-E-Games-Logo.png" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2024/05/Detroit-4-Corners-Pizza-Logo.jpeg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2024/06/Fatafat-Logo-scaled.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2024/06/Happy-Bites-Logo.png" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2024/06/Kalanki-Gym-Center-Logo.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2024/06/Swimfit-Nepal-Logo1.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2024/07/The-Bell-Bar-and-Bistro-Logo.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2024/07/OOPS-NEPAL-LOGO.png" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2024/09/Mirch-Hospitality-Logo.jpeg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2025/01/We-Care-Health-Center-logo.png" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2025/01/Vanity-Men-Logo-1.png" alt="#"></a></div>
               
  </div>
</div>
            
                  
            </div>
          <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab" tabindex="0">
              <div class="swiper partner-slider">
  <!-- Additional required wrapper -->
  <div class="swiper-wrapper">
    <!-- Slides -->
                  <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/07/midas.jpg" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/07/sct.jpg" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/07/tow.jpg" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/08/Screenshot_145.png" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/08/Screenshot_144.png" alt="#"></div>
               
  </div>
</div>
          </div>
          <div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab" tabindex="0">
               <div class="swiper partner-slider">
  <!-- Additional required wrapper -->
  <div class="swiper-wrapper">
    <!-- Slides -->
                  <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/07/cisco.jpg" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/07/nren.jpg" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/07/office.jpg" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/07/HA.jpg" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2024/07/AIT_globe.webp" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2025/01/Vector-Smart-Object.svg" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/08/Screenshot_148.png" alt="#"></div>
               
  </div>
</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- End Our Partner -->



	<!-- Start Footer -->
<footer>
  <div class="footer-top">
    <div class="container">
      <div class="row">
        <div class="col-md-6 col-lg-3">
          <div class="footer-item">
            <a href="https://prime.edu.np" class="footer-logo">
              <img src="https://prime.edu.np/wp-content/uploads/2023/09/Prime-College-Logo.svg" alt="logo">
            </a>
            <ul class="footer-contact">
              <li>Khusibun, Nayabazar, Kathmandu</li>
              <li><a href="tel:01-4961690">01-4961690</a>, <a href="tel:01-4970072">01-4970072</a></li>
              <li><a href="/cdn-cgi/l/email-protection#8ee7e0e8e1cefefce7e3eba0ebeafba0e0fe"><span class="__cf_email__" data-cfemail="cba2a5ada48bbbb9a2a6aee5aeafbee5a5bb">[email&#160;protected]</span></a>,   <a href="/cdn-cgi/l/email-protection#741510191d07071d1b1a073404061d19115a1110015a1a0454"><span class="__cf_email__" data-cfemail="e48580898d97978d8b8a97a494968d8981ca818091ca8a94">[email&#160;protected]</span>  </a></li>
              <li><p>You can visit Prime College between 7:00 a.m. - 5:00 p.m. for more information.</p></li>
            </ul>
            <h5>Join Our Community</h5>
            <ul class="si-wrap">
      <li><a href="https://www.facebook.com/primecollegenp" target="_blank"><i class="fa-brands fa-facebook-f"></i></a></li>
          <li><a href="https://www.youtube.com/user/primecollege1" target="_blank"><i class="fa-brands fa-youtube"></i></a></li>
          <li><a href="https://www.instagram.com/prime__college/?hl=en" target="_blank"><i class="fa-brands fa-instagram"></i></a></li>
          <li><a href="https://np.linkedin.com/company/prime-college-nepal" target="_blank"><i class="fa-brands fa-linkedin-in"></i></a></li>
          <li><a href="https://www.tiktok.com/@prime_college" target="_blank"><i class="fa-brands fa-tiktok"></i></a></li>
        </ul>
          </div>
        </div>
        <div class="col-md-6 col-lg-3">
          <div class="footer-item">
            <h6>Quick Links</h6>
             <ul id="menu-quick-links" class="menu"><li id="menu-item-494" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-494"><a href="https://prime.edu.np/faq/">FAQ</a></li>
<li id="menu-item-577" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-577"><a href="https://prime.edu.np/mlrc/">MLRC</a></li>
<li id="menu-item-576" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-576"><a href="https://prime.edu.np/eso/">ESO</a></li>
<li id="menu-item-1125" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1125"><a href="https://prime.edu.np/career/">Prime Career Center</a></li>
<li id="menu-item-1126" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1126"><a href="https://prime.edu.np/team/">Know Our Team</a></li>
<li id="menu-item-493" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-493"><a href="https://prime.edu.np/about/">Who We Are</a></li>
<li id="menu-item-1127" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1127"><a href="https://prime.edu.np/character-certificate-form/">Character Certificate Form</a></li>
<li id="menu-item-1128" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1128"><a href="https://prime.edu.np/hall-booking/">Seminar Hall Booking</a></li>
<li id="menu-item-495" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-495"><a href="https://prime.edu.np/apply-now/">Apply Now</a></li>
</ul>          </div>
        </div>
        <div class="col-md-6 col-lg-3">
          <div class="footer-item">
            <h6>Bachelor Programs</h6>
             <ul id="menu-footer-program-menu" class="menu"><li id="menu-item-876" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-876"><a href="https://prime.edu.np/program/bachelor-of-business-studies/">BBS</a></li>
<li id="menu-item-877" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-877"><a href="https://prime.edu.np/program/bbm/">BBM</a></li>
<li id="menu-item-878" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-878"><a href="https://prime.edu.np/program/bim/">BIM</a></li>
<li id="menu-item-879" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-879"><a href="https://prime.edu.np/program/bachelor-of-business-administration/">BBA</a></li>
<li id="menu-item-880" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-880"><a href="https://prime.edu.np/program/bachelor-of-computer-applications/">BCA</a></li>
<li id="menu-item-881" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-881"><a href="https://prime.edu.np/program/bachelors-of-science-in-csit/">BSc. CSIT</a></li>
</ul>          </div>
        </div>
        <div class="col-md-6 col-lg-3">
          <div class="footer-item">
            <h6>Master Program</h6>
             <ul id="menu-footer-master-menu" class="menu"><li id="menu-item-882" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-882"><a href="https://prime.edu.np/program/mbs/">MBS</a></li>
</ul>          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="footer-btm">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <p>© 2025 Prime College. All Rights Reserved. Website Designed & Developed by <a href="https://themenepal.com/">Theme Nepal</a></p>
        </div>
        <!--<div class="col-md-6 text-lg-end">-->
        <!--  <p>Website Designed & Developed by <a href="https://themenepal.com/">Theme Nepal</a></p>-->
        <!--</div>-->
      </div>
    </div>
  </div>
</footer>
<!-- End Footer -->



<!-- GetButton.io widget -->
<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script type="text/javascript">
(function () {
var options = {
            facebook: "100071046916926", 
            whatsapp: "+977-9820112011", 
            call_to_action: "Message us", 
            button_color: "#f4be40", 
            position: "right", 
            order: "whatsapp,viber,facebook", 
        };
    var proto = 'https:', host = "getbutton.io", url = proto + '//static.' + host;
    var s = document.createElement('script'); s.type = 'text/javascript'; s.async = true; s.src = url + '/widget-send-button/js/init.js';
    s.onload = function () { WhWidgetSendButton.init(host, proto, options); };
    var x = document.getElementsByTagName('script')[0]; x.parentNode.insertBefore(s, x);
})();
</script>
<!-- /GetButton.io widget -->


<!-- WP Socializer 7.9 - JS - Start -->

<!-- WP Socializer - JS - End -->
<div class="wp-socializer wpsr-follow-icons sr-fb-rm sr-fb-vl" data-lg-action="show" data-sm-action="show" data-sm-width="768"><div class="socializer sr-followbar sr-32px sr-drop sr-zoom sr-pad sr-vertical"><span class="sr-facebook"><a data-id="facebook" style="color:#ffffff;" rel="nofollow me" href="https://www.facebook.com/primecollegenp" target="_blank" title="Facebook"><i class="fab fa-facebook-f"></i></a></span><span class="sr-youtube"><a data-id="youtube" style="color:#ffffff;" rel="nofollow me" href="https://www.youtube.com/user/primecollege1" target="_blank" title="Youtube"><i class="fab fa-youtube"></i></a></span><span class="sr-instagram"><a data-id="instagram" style="color:#ffffff;" rel="nofollow me" href="https://www.instagram.com/prime__college/?hl=en" target="_blank" title="Instagram"><i class="fab fa-instagram"></i></a></span><span class="sr-linkedin"><a data-id="linkedin" style="color:#ffffff;" rel="nofollow me" href="https://np.linkedin.com/company/prime-college-nepal" target="_blank" title="LinkedIn"><i class="fab fa-linkedin-in"></i></a></span><span class="sr-tiktok"><a data-id="tiktok" style="color:#ffffff;" rel="nofollow me" href="https://www.tiktok.com/@prime_college" target="_blank" title="TikTok"><i class="fab fa-tiktok"></i></a></span></div><div class="wpsr-fb-close wpsr-close-btn" title="Open or close follow icons"><span class="wpsr-bar-icon"><svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" viewBox="0 0 16 16" class="i-open"><path d="M15,6h-5V1c0-0.55-0.45-1-1-1H7C6.45,0,6,0.45,6,1v5H1C0.45,6,0,6.45,0,7v2c0,0.55,0.45,1,1,1h5v5c0,0.55,0.45,1,1,1h2 c0.55,0,1-0.45,1-1v-5h5c0.55,0,1-0.45,1-1V7C16,6.45,15.55,6,15,6z"/></svg><svg class="i-close" xmlns="http://www.w3.org/2000/svg" width="10" height="10" viewBox="0 0 512 512"><path d="M417.4,224H94.6C77.7,224,64,238.3,64,256c0,17.7,13.7,32,30.6,32h322.8c16.9,0,30.6-14.3,30.6-32 C448,238.3,434.3,224,417.4,224z"/></svg></span></div></div><div id="pum-2316" role="dialog" aria-modal="false"  class="pum pum-overlay pum-theme-2307 pum-theme-default-theme popmake-overlay pum-click-to-close auto_open click_open" data-popmake="{&quot;id&quot;:2316,&quot;slug&quot;:&quot;pc-counselling-open-2081&quot;,&quot;theme_id&quot;:2307,&quot;cookies&quot;:[{&quot;event&quot;:&quot;on_popup_close&quot;,&quot;settings&quot;:{&quot;name&quot;:&quot;pum-2316&quot;,&quot;key&quot;:&quot;&quot;,&quot;session&quot;:null,&quot;path&quot;:true,&quot;time&quot;:&quot;1 sec&quot;}}],&quot;triggers&quot;:[{&quot;type&quot;:&quot;auto_open&quot;,&quot;settings&quot;:{&quot;cookie_name&quot;:[&quot;pum-2316&quot;],&quot;delay&quot;:&quot;500&quot;}},{&quot;type&quot;:&quot;click_open&quot;,&quot;settings&quot;:{&quot;extra_selectors&quot;:&quot;&quot;,&quot;cookie_name&quot;:null}}],&quot;mobile_disabled&quot;:null,&quot;tablet_disabled&quot;:null,&quot;meta&quot;:{&quot;display&quot;:{&quot;stackable&quot;:false,&quot;overlay_disabled&quot;:false,&quot;scrollable_content&quot;:false,&quot;disable_reposition&quot;:false,&quot;size&quot;:&quot;medium&quot;,&quot;responsive_min_width&quot;:&quot;0%&quot;,&quot;responsive_min_width_unit&quot;:false,&quot;responsive_max_width&quot;:&quot;100%&quot;,&quot;responsive_max_width_unit&quot;:false,&quot;custom_width&quot;:&quot;640px&quot;,&quot;custom_width_unit&quot;:false,&quot;custom_height&quot;:&quot;380px&quot;,&quot;custom_height_unit&quot;:false,&quot;custom_height_auto&quot;:false,&quot;location&quot;:&quot;center&quot;,&quot;position_from_trigger&quot;:false,&quot;position_top&quot;:&quot;100&quot;,&quot;position_left&quot;:&quot;0&quot;,&quot;position_bottom&quot;:&quot;0&quot;,&quot;position_right&quot;:&quot;0&quot;,&quot;position_fixed&quot;:false,&quot;animation_type&quot;:&quot;fade&quot;,&quot;animation_speed&quot;:&quot;350&quot;,&quot;animation_origin&quot;:&quot;center top&quot;,&quot;overlay_zindex&quot;:false,&quot;zindex&quot;:&quot;1999999999&quot;},&quot;close&quot;:{&quot;text&quot;:&quot;&quot;,&quot;button_delay&quot;:&quot;500&quot;,&quot;overlay_click&quot;:&quot;1&quot;,&quot;esc_press&quot;:false,&quot;f4_press&quot;:false},&quot;click_open&quot;:[]}}">

	<div id="popmake-2316" class="pum-container popmake theme-2307 pum-responsive pum-responsive-medium responsive size-medium">

				
				
		
				<div class="pum-content popmake-content" tabindex="0">
			<h2 style="text-align: center;"></h2>
<p><img fetchpriority="high" decoding="async" class="alignnone wp-image-3177 size-full" src="https://prime.edu.np/wp-content/uploads/2024/03/Counselling_Open_1.1_.png" alt="" width="1080" height="1080" srcset="https://prime.edu.np/wp-content/uploads/2024/03/Counselling_Open_1.1_.png 1080w, https://prime.edu.np/wp-content/uploads/2024/03/Counselling_Open_1.1_-300x300.png 300w, https://prime.edu.np/wp-content/uploads/2024/03/Counselling_Open_1.1_-1024x1024.png 1024w, https://prime.edu.np/wp-content/uploads/2024/03/Counselling_Open_1.1_-150x150.png 150w, https://prime.edu.np/wp-content/uploads/2024/03/Counselling_Open_1.1_-768x768.png 768w" sizes="(max-width: 1080px) 100vw, 1080px" /></p>
<h4 style="text-align: center;"><a href="https://prime.edu.np/apply-now/" target="_blank" rel="noopener">For Inquiry &#8211; </a><a href="https://prime.edu.np/apply-now/"> </a><a href="https://prime.edu.np/apply-now/" target="_blank" rel="noopener">https://prime.edu.np/apply-now/</a></h4>
		</div>

				
							<button type="button" class="pum-close popmake-close" aria-label="Close">
			CLOSE			</button>
		
	</div>

</div>
<script src="https://prime.edu.np/wp-includes/js/dist/hooks.min.js?ver=4d63a3d491d11ffd8ac6" id="wp-hooks-js"></script>
<script src="https://prime.edu.np/wp-includes/js/dist/i18n.min.js?ver=5e580eb46a90c2b997e6" id="wp-i18n-js"></script>
<script id="wp-i18n-js-after">
wp.i18n.setLocaleData( { 'text direction\u0004ltr': [ 'ltr' ] } );
</script>
<script src="https://prime.edu.np/wp-content/plugins/contact-form-7/includes/swv/js/index.js?ver=6.0.3" id="swv-js"></script>
<script id="contact-form-7-js-before">
var wpcf7 = {
    "api": {
        "root": "https:\/\/prime.edu.np\/wp-json\/",
        "namespace": "contact-form-7\/v1"
    },
    "cached": 1
};
</script>
<script src="https://prime.edu.np/wp-content/plugins/contact-form-7/includes/js/index.js?ver=6.0.3" id="contact-form-7-js"></script>
<script src="https://prime.edu.np/wp-content/themes/prime-college/js/navigation.js?ver=1.0.0" id="prime-college-navigation-js"></script>
<script src="https://prime.edu.np/wp-includes/js/jquery/ui/core.min.js?ver=1.13.3" id="jquery-ui-core-js"></script>
<script id="popup-maker-site-js-extra">
var pum_vars = {"version":"1.20.3","pm_dir_url":"https:\/\/prime.edu.np\/wp-content\/plugins\/popup-maker\/","ajaxurl":"https:\/\/prime.edu.np\/wp-admin\/admin-ajax.php","restapi":"https:\/\/prime.edu.np\/wp-json\/pum\/v1","rest_nonce":null,"default_theme":"2307","debug_mode":"","disable_tracking":"","home_url":"\/","message_position":"top","core_sub_forms_enabled":"1","popups":[],"cookie_domain":"","analytics_route":"analytics","analytics_api":"https:\/\/prime.edu.np\/wp-json\/pum\/v1"};
var pum_sub_vars = {"ajaxurl":"https:\/\/prime.edu.np\/wp-admin\/admin-ajax.php","message_position":"top"};
var pum_popups = {"pum-2316":{"triggers":[{"type":"auto_open","settings":{"cookie_name":["pum-2316"],"delay":"500"}}],"cookies":[{"event":"on_popup_close","settings":{"name":"pum-2316","key":"","session":null,"path":true,"time":"1 sec"}}],"disable_on_mobile":false,"disable_on_tablet":false,"atc_promotion":null,"explain":null,"type_section":null,"theme_id":"2307","size":"medium","responsive_min_width":"0%","responsive_max_width":"100%","custom_width":"640px","custom_height_auto":false,"custom_height":"380px","scrollable_content":false,"animation_type":"fade","animation_speed":"350","animation_origin":"center top","open_sound":"none","custom_sound":"","location":"center","position_top":"100","position_bottom":"0","position_left":"0","position_right":"0","position_from_trigger":false,"position_fixed":false,"overlay_disabled":false,"stackable":false,"disable_reposition":false,"zindex":"1999999999","close_button_delay":"500","fi_promotion":null,"close_on_form_submission":true,"close_on_form_submission_delay":"0","close_on_overlay_click":true,"close_on_esc_press":false,"close_on_f4_press":false,"disable_form_reopen":false,"disable_accessibility":false,"theme_slug":"default-theme","id":2316,"slug":"pc-counselling-open-2081"}};
</script>
<script src="https://prime.edu.np/wp-content/plugins/popup-maker/assets/js/site.min.js?defer&amp;ver=1.20.3" id="popup-maker-site-js"></script>
<script id="wpsr_main_js-js-extra">
var wp_socializer = {"ajax_url":"https:\/\/prime.edu.np\/wp-admin\/admin-ajax.php"};
</script>
<script src="https://prime.edu.np/wp-content/plugins/wp-socializer/public/js/wp-socializer.min.js?ver=7.9" id="wpsr_main_js-js"></script>
<!-- ----------Scripts--------- -->
<script src="https://prime.edu.np/wp-content/themes/prime-college/assets/js/jquery-3.7.0.min.js"></script>
    <script src="https://prime.edu.np/wp-content/themes/prime-college/assets/js/bootstrap.bundle.min.js"></script>
    <script src="https://prime.edu.np/wp-content/themes/prime-college/assets/vendor/fontawesome/js/all.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
    <script src="https://prime.edu.np/wp-content/themes/prime-college/assets/vendor/fancybox/jquery.fancybox.min.js"></script>
    <script src="https://prime.edu.np/wp-content/themes/prime-college/assets/vendor/jquery.matchHeight-min.js"></script>
    <script src="https://prime.edu.np/wp-content/themes/prime-college/assets/js/script.js"></script>
    
    <script>
        $(document).ready(function(){
        $(".fancybox").fancybox({
}); 
}); 
    </script>
   

<script>
    $(document).ready(function(){
        // Our Program Slider
  var programswiper = new Swiper(".our-program-slider", {
      loop: true,
      loopedSlides:1,
    spaceBetween: 10,
    slidesPerView: 1,
    speed:1000,
    autoplay: {
      delay: 2500,
      disableOnInteraction: false,
    },
    
    breakpoints: {
      640: {
        slidesPerView: 2,
        loopedSlides:2,
        spaceBetween: 20,
      },
      768: {
        slidesPerView: 3,
        loopedSlides:3,
      },
      1024: {
        slidesPerView: 4,
        loopedSlides:4,
        spaceBetween: 30,
      },
    },
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },
  });
    });
</script>

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

### **Example 3: Retrieving HTTP Headers Using `URLConnection` in Java**

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

### **Example 4: Printing the Entire HTTP Header Using `URLConnection` in Java**

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


### **Example 5: Printing the URL of a `URLConnection` in Java**

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
### **Example 6:Program to print all response from server**

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

<link rel="stylesheet" href="https://prime.edu.np/wp-content/themes/prime-college/assets/vendor/fancybox/jquery.fancybox.min.css">

    <!-- -----Custom Style----- -->
<link rel="stylesheet" href="https://prime.edu.np/wp-content/themes/prime-college/assets/css/style.css">
<link rel="stylesheet" href="https://prime.edu.np/wp-content/themes/prime-college/assets/css/responsive.css"/>

	<title>Home - Prime College</title>
	<style>img:is([sizes="auto" i], [sizes^="auto," i]) { contain-intrinsic-size: 3000px 1500px }</style>
	
		<!-- All in One SEO 4.7.8 - aioseo.com -->
	<meta name="robots" content="max-image-preview:large" />
	<link rel="canonical" href="https://prime.edu.np/" />
	<meta name="generator" content="All in One SEO (AIOSEO) 4.7.8" />
		<meta property="og:locale" content="en_US" />
		<meta property="og:site_name" content="Prime College -" />
		<meta property="og:type" content="website" />
		<meta property="og:title" content="Home - Prime College" />
		<meta property="og:url" content="https://prime.edu.np/" />
		<meta name="twitter:card" content="summary_large_image" />
		<meta name="twitter:title" content="Home - Prime College" />
		<script type="application/ld+json" class="aioseo-schema">
			{"@context":"https:\/\/schema.org","@graph":[{"@type":"BreadcrumbList","@id":"https:\/\/prime.edu.np\/#breadcrumblist","itemListElement":[{"@type":"ListItem","@id":"https:\/\/prime.edu.np\/#listItem","position":1,"name":"Home"}]},{"@type":"Organization","@id":"https:\/\/prime.edu.np\/#organization","name":"Prime College","url":"https:\/\/prime.edu.np\/"},{"@type":"WebPage","@id":"https:\/\/prime.edu.np\/#webpage","url":"https:\/\/prime.edu.np\/","name":"Home - Prime College","inLanguage":"en-US","isPartOf":{"@id":"https:\/\/prime.edu.np\/#website"},"breadcrumb":{"@id":"https:\/\/prime.edu.np\/#breadcrumblist"},"datePublished":"2023-07-25T10:06:00+05:45","dateModified":"2025-01-01T16:01:06+05:45"},{"@type":"WebSite","@id":"https:\/\/prime.edu.np\/#website","url":"https:\/\/prime.edu.np\/","name":"Prime College","inLanguage":"en-US","publisher":{"@id":"https:\/\/prime.edu.np\/#organization"},"potentialAction":{"@type":"SearchAction","target":{"@type":"EntryPoint","urlTemplate":"https:\/\/prime.edu.np\/?s={search_term_string}"},"query-input":"required name=search_term_string"}}]}
		</script>
		<!-- All in One SEO -->

<link rel='dns-prefetch' href='//use.fontawesome.com' />
<link rel="alternate" type="application/rss+xml" title="Prime College &raquo; Feed" href="https://prime.edu.np/feed/" />
<link rel="alternate" type="application/rss+xml" title="Prime College &raquo; Comments Feed" href="https://prime.edu.np/comments/feed/" />
<script>
window._wpemojiSettings = {"baseUrl":"https:\/\/s.w.org\/images\/core\/emoji\/15.0.3\/72x72\/","ext":".png","svgUrl":"https:\/\/s.w.org\/images\/core\/emoji\/15.0.3\/svg\/","svgExt":".svg","source":{"concatemoji":"https:\/\/prime.edu.np\/wp-includes\/js\/wp-emoji-release.min.js?ver=6.7.1"}};
/*! This file is auto-generated */
!function(i,n){var o,s,e;function c(e){try{var t={supportTests:e,timestamp:(new Date).valueOf()};sessionStorage.setItem(o,JSON.stringify(t))}catch(e){}}function p(e,t,n){e.clearRect(0,0,e.canvas.width,e.canvas.height),e.fillText(t,0,0);var t=new Uint32Array(e.getImageData(0,0,e.canvas.width,e.canvas.height).data),r=(e.clearRect(0,0,e.canvas.width,e.canvas.height),e.fillText(n,0,0),new Uint32Array(e.getImageData(0,0,e.canvas.width,e.canvas.height).data));return t.every(function(e,t){return e===r[t]})}function u(e,t,n){switch(t){case"flag":return n(e,"\ud83c\udff3\ufe0f\u200d\u26a7\ufe0f","\ud83c\udff3\ufe0f\u200b\u26a7\ufe0f")?!1:!n(e,"\ud83c\uddfa\ud83c\uddf3","\ud83c\uddfa\u200b\ud83c\uddf3")&&!n(e,"\ud83c\udff4\udb40\udc67\udb40\udc62\udb40\udc65\udb40\udc6e\udb40\udc67\udb40\udc7f","\ud83c\udff4\u200b\udb40\udc67\u200b\udb40\udc62\u200b\udb40\udc65\u200b\udb40\udc6e\u200b\udb40\udc67\u200b\udb40\udc7f");case"emoji":return!n(e,"\ud83d\udc26\u200d\u2b1b","\ud83d\udc26\u200b\u2b1b")}return!1}function f(e,t,n){var r="undefined"!=typeof WorkerGlobalScope&&self instanceof WorkerGlobalScope?new OffscreenCanvas(300,150):i.createElement("canvas"),a=r.getContext("2d",{willReadFrequently:!0}),o=(a.textBaseline="top",a.font="600 32px Arial",{});return e.forEach(function(e){o[e]=t(a,e,n)}),o}function t(e){var t=i.createElement("script");t.src=e,t.defer=!0,i.head.appendChild(t)}"undefined"!=typeof Promise&&(o="wpEmojiSettingsSupports",s=["flag","emoji"],n.supports={everything:!0,everythingExceptFlag:!0},e=new Promise(function(e){i.addEventListener("DOMContentLoaded",e,{once:!0})}),new Promise(function(t){var n=function(){try{var e=JSON.parse(sessionStorage.getItem(o));if("object"==typeof e&&"number"==typeof e.timestamp&&(new Date).valueOf()<e.timestamp+604800&&"object"==typeof e.supportTests)return e.supportTests}catch(e){}return null}();if(!n){if("undefined"!=typeof Worker&&"undefined"!=typeof OffscreenCanvas&&"undefined"!=typeof URL&&URL.createObjectURL&&"undefined"!=typeof Blob)try{var e="postMessage("+f.toString()+"("+[JSON.stringify(s),u.toString(),p.toString()].join(",")+"));",r=new Blob([e],{type:"text/javascript"}),a=new Worker(URL.createObjectURL(r),{name:"wpTestEmojiSupports"});return void(a.onmessage=function(e){c(n=e.data),a.terminate(),t(n)})}catch(e){}c(n=f(s,u,p))}t(n)}).then(function(e){for(var t in e)n.supports[t]=e[t],n.supports.everything=n.supports.everything&&n.supports[t],"flag"!==t&&(n.supports.everythingExceptFlag=n.supports.everythingExceptFlag&&n.supports[t]);n.supports.everythingExceptFlag=n.supports.everythingExceptFlag&&!n.supports.flag,n.DOMReady=!1,n.readyCallback=function(){n.DOMReady=!0}}).then(function(){return e}).then(function(){var e;n.supports.everything||(n.readyCallback(),(e=n.source||{}).concatemoji?t(e.concatemoji):e.wpemoji&&e.twemoji&&(t(e.twemoji),t(e.wpemoji)))}))}((window,document),window._wpemojiSettings);
</script>
<style id='wp-emoji-styles-inline-css'>

	img.wp-smiley, img.emoji {
		display: inline !important;
		border: none !important;
		box-shadow: none !important;
		height: 1em !important;
		width: 1em !important;
		margin: 0 0.07em !important;
		vertical-align: -0.1em !important;
		background: none !important;
		padding: 0 !important;
	}
</style>
<link rel='stylesheet' id='wp-block-library-css' href='https://prime.edu.np/wp-includes/css/dist/block-library/style.min.css?ver=6.7.1' media='all' />
<style id='classic-theme-styles-inline-css'>
/*! This file is auto-generated */
.wp-block-button__link{color:#fff;background-color:#32373c;border-radius:9999px;box-shadow:none;text-decoration:none;padding:calc(.667em + 2px) calc(1.333em + 2px);font-size:1.125em}.wp-block-file__button{background:#32373c;color:#fff;text-decoration:none}
</style>
<style id='global-styles-inline-css'>
:root{--wp--preset--aspect-ratio--square: 1;--wp--preset--aspect-ratio--4-3: 4/3;--wp--preset--aspect-ratio--3-4: 3/4;--wp--preset--aspect-ratio--3-2: 3/2;--wp--preset--aspect-ratio--2-3: 2/3;--wp--preset--aspect-ratio--16-9: 16/9;--wp--preset--aspect-ratio--9-16: 9/16;--wp--preset--color--black: #000000;--wp--preset--color--cyan-bluish-gray: #abb8c3;--wp--preset--color--white: #ffffff;--wp--preset--color--pale-pink: #f78da7;--wp--preset--color--vivid-red: #cf2e2e;--wp--preset--color--luminous-vivid-orange: #ff6900;--wp--preset--color--luminous-vivid-amber: #fcb900;--wp--preset--color--light-green-cyan: #7bdcb5;--wp--preset--color--vivid-green-cyan: #00d084;--wp--preset--color--pale-cyan-blue: #8ed1fc;--wp--preset--color--vivid-cyan-blue: #0693e3;--wp--preset--color--vivid-purple: #9b51e0;--wp--preset--gradient--vivid-cyan-blue-to-vivid-purple: linear-gradient(135deg,rgba(6,147,227,1) 0%,rgb(155,81,224) 100%);--wp--preset--gradient--light-green-cyan-to-vivid-green-cyan: linear-gradient(135deg,rgb(122,220,180) 0%,rgb(0,208,130) 100%);--wp--preset--gradient--luminous-vivid-amber-to-luminous-vivid-orange: linear-gradient(135deg,rgba(252,185,0,1) 0%,rgba(255,105,0,1) 100%);--wp--preset--gradient--luminous-vivid-orange-to-vivid-red: linear-gradient(135deg,rgba(255,105,0,1) 0%,rgb(207,46,46) 100%);--wp--preset--gradient--very-light-gray-to-cyan-bluish-gray: linear-gradient(135deg,rgb(238,238,238) 0%,rgb(169,184,195) 100%);--wp--preset--gradient--cool-to-warm-spectrum: linear-gradient(135deg,rgb(74,234,220) 0%,rgb(151,120,209) 20%,rgb(207,42,186) 40%,rgb(238,44,130) 60%,rgb(251,105,98) 80%,rgb(254,248,76) 100%);--wp--preset--gradient--blush-light-purple: linear-gradient(135deg,rgb(255,206,236) 0%,rgb(152,150,240) 100%);--wp--preset--gradient--blush-bordeaux: linear-gradient(135deg,rgb(254,205,165) 0%,rgb(254,45,45) 50%,rgb(107,0,62) 100%);--wp--preset--gradient--luminous-dusk: linear-gradient(135deg,rgb(255,203,112) 0%,rgb(199,81,192) 50%,rgb(65,88,208) 100%);--wp--preset--gradient--pale-ocean: linear-gradient(135deg,rgb(255,245,203) 0%,rgb(182,227,212) 50%,rgb(51,167,181) 100%);--wp--preset--gradient--electric-grass: linear-gradient(135deg,rgb(202,248,128) 0%,rgb(113,206,126) 100%);--wp--preset--gradient--midnight: linear-gradient(135deg,rgb(2,3,129) 0%,rgb(40,116,252) 100%);--wp--preset--font-size--small: 13px;--wp--preset--font-size--medium: 20px;--wp--preset--font-size--large: 36px;--wp--preset--font-size--x-large: 42px;--wp--preset--spacing--20: 0.44rem;--wp--preset--spacing--30: 0.67rem;--wp--preset--spacing--40: 1rem;--wp--preset--spacing--50: 1.5rem;--wp--preset--spacing--60: 2.25rem;--wp--preset--spacing--70: 3.38rem;--wp--preset--spacing--80: 5.06rem;--wp--preset--shadow--natural: 6px 6px 9px rgba(0, 0, 0, 0.2);--wp--preset--shadow--deep: 12px 12px 50px rgba(0, 0, 0, 0.4);--wp--preset--shadow--sharp: 6px 6px 0px rgba(0, 0, 0, 0.2);--wp--preset--shadow--outlined: 6px 6px 0px -3px rgba(255, 255, 255, 1), 6px 6px rgba(0, 0, 0, 1);--wp--preset--shadow--crisp: 6px 6px 0px rgba(0, 0, 0, 1);}:where(.is-layout-flex){gap: 0.5em;}:where(.is-layout-grid){gap: 0.5em;}body .is-layout-flex{display: flex;}.is-layout-flex{flex-wrap: wrap;align-items: center;}.is-layout-flex > :is(*, div){margin: 0;}body .is-layout-grid{display: grid;}.is-layout-grid > :is(*, div){margin: 0;}:where(.wp-block-columns.is-layout-flex){gap: 2em;}:where(.wp-block-columns.is-layout-grid){gap: 2em;}:where(.wp-block-post-template.is-layout-flex){gap: 1.25em;}:where(.wp-block-post-template.is-layout-grid){gap: 1.25em;}.has-black-color{color: var(--wp--preset--color--black) !important;}.has-cyan-bluish-gray-color{color: var(--wp--preset--color--cyan-bluish-gray) !important;}.has-white-color{color: var(--wp--preset--color--white) !important;}.has-pale-pink-color{color: var(--wp--preset--color--pale-pink) !important;}.has-vivid-red-color{color: var(--wp--preset--color--vivid-red) !important;}.has-luminous-vivid-orange-color{color: var(--wp--preset--color--luminous-vivid-orange) !important;}.has-luminous-vivid-amber-color{color: var(--wp--preset--color--luminous-vivid-amber) !important;}.has-light-green-cyan-color{color: var(--wp--preset--color--light-green-cyan) !important;}.has-vivid-green-cyan-color{color: var(--wp--preset--color--vivid-green-cyan) !important;}.has-pale-cyan-blue-color{color: var(--wp--preset--color--pale-cyan-blue) !important;}.has-vivid-cyan-blue-color{color: var(--wp--preset--color--vivid-cyan-blue) !important;}.has-vivid-purple-color{color: var(--wp--preset--color--vivid-purple) !important;}.has-black-background-color{background-color: var(--wp--preset--color--black) !important;}.has-cyan-bluish-gray-background-color{background-color: var(--wp--preset--color--cyan-bluish-gray) !important;}.has-white-background-color{background-color: var(--wp--preset--color--white) !important;}.has-pale-pink-background-color{background-color: var(--wp--preset--color--pale-pink) !important;}.has-vivid-red-background-color{background-color: var(--wp--preset--color--vivid-red) !important;}.has-luminous-vivid-orange-background-color{background-color: var(--wp--preset--color--luminous-vivid-orange) !important;}.has-luminous-vivid-amber-background-color{background-color: var(--wp--preset--color--luminous-vivid-amber) !important;}.has-light-green-cyan-background-color{background-color: var(--wp--preset--color--light-green-cyan) !important;}.has-vivid-green-cyan-background-color{background-color: var(--wp--preset--color--vivid-green-cyan) !important;}.has-pale-cyan-blue-background-color{background-color: var(--wp--preset--color--pale-cyan-blue) !important;}.has-vivid-cyan-blue-background-color{background-color: var(--wp--preset--color--vivid-cyan-blue) !important;}.has-vivid-purple-background-color{background-color: var(--wp--preset--color--vivid-purple) !important;}.has-black-border-color{border-color: var(--wp--preset--color--black) !important;}.has-cyan-bluish-gray-border-color{border-color: var(--wp--preset--color--cyan-bluish-gray) !important;}.has-white-border-color{border-color: var(--wp--preset--color--white) !important;}.has-pale-pink-border-color{border-color: var(--wp--preset--color--pale-pink) !important;}.has-vivid-red-border-color{border-color: var(--wp--preset--color--vivid-red) !important;}.has-luminous-vivid-orange-border-color{border-color: var(--wp--preset--color--luminous-vivid-orange) !important;}.has-luminous-vivid-amber-border-color{border-color: var(--wp--preset--color--luminous-vivid-amber) !important;}.has-light-green-cyan-border-color{border-color: var(--wp--preset--color--light-green-cyan) !important;}.has-vivid-green-cyan-border-color{border-color: var(--wp--preset--color--vivid-green-cyan) !important;}.has-pale-cyan-blue-border-color{border-color: var(--wp--preset--color--pale-cyan-blue) !important;}.has-vivid-cyan-blue-border-color{border-color: var(--wp--preset--color--vivid-cyan-blue) !important;}.has-vivid-purple-border-color{border-color: var(--wp--preset--color--vivid-purple) !important;}.has-vivid-cyan-blue-to-vivid-purple-gradient-background{background: var(--wp--preset--gradient--vivid-cyan-blue-to-vivid-purple) !important;}.has-light-green-cyan-to-vivid-green-cyan-gradient-background{background: var(--wp--preset--gradient--light-green-cyan-to-vivid-green-cyan) !important;}.has-luminous-vivid-amber-to-luminous-vivid-orange-gradient-background{background: var(--wp--preset--gradient--luminous-vivid-amber-to-luminous-vivid-orange) !important;}.has-luminous-vivid-orange-to-vivid-red-gradient-background{background: var(--wp--preset--gradient--luminous-vivid-orange-to-vivid-red) !important;}.has-very-light-gray-to-cyan-bluish-gray-gradient-background{background: var(--wp--preset--gradient--very-light-gray-to-cyan-bluish-gray) !important;}.has-cool-to-warm-spectrum-gradient-background{background: var(--wp--preset--gradient--cool-to-warm-spectrum) !important;}.has-blush-light-purple-gradient-background{background: var(--wp--preset--gradient--blush-light-purple) !important;}.has-blush-bordeaux-gradient-background{background: var(--wp--preset--gradient--blush-bordeaux) !important;}.has-luminous-dusk-gradient-background{background: var(--wp--preset--gradient--luminous-dusk) !important;}.has-pale-ocean-gradient-background{background: var(--wp--preset--gradient--pale-ocean) !important;}.has-electric-grass-gradient-background{background: var(--wp--preset--gradient--electric-grass) !important;}.has-midnight-gradient-background{background: var(--wp--preset--gradient--midnight) !important;}.has-small-font-size{font-size: var(--wp--preset--font-size--small) !important;}.has-medium-font-size{font-size: var(--wp--preset--font-size--medium) !important;}.has-large-font-size{font-size: var(--wp--preset--font-size--large) !important;}.has-x-large-font-size{font-size: var(--wp--preset--font-size--x-large) !important;}
:where(.wp-block-post-template.is-layout-flex){gap: 1.25em;}:where(.wp-block-post-template.is-layout-grid){gap: 1.25em;}
:where(.wp-block-columns.is-layout-flex){gap: 2em;}:where(.wp-block-columns.is-layout-grid){gap: 2em;}
:root :where(.wp-block-pullquote){font-size: 1.5em;line-height: 1.6;}
</style>
<link rel='stylesheet' id='contact-form-7-css' href='https://prime.edu.np/wp-content/plugins/contact-form-7/includes/css/styles.css?ver=6.0.3' media='all' />
<style id='contact-form-7-inline-css'>
.wpcf7 .wpcf7-recaptcha iframe {margin-bottom: 0;}.wpcf7 .wpcf7-recaptcha[data-align="center"] > div {margin: 0 auto;}.wpcf7 .wpcf7-recaptcha[data-align="right"] > div {margin: 0 0 0 auto;}
</style>
<link rel='stylesheet' id='wpsr_main_css-css' href='https://prime.edu.np/wp-content/plugins/wp-socializer/public/css/wpsr.min.css?ver=7.9' media='all' />
<link rel='stylesheet' id='wpsr_fa_icons-css' href='https://use.fontawesome.com/releases/v6.7.2/css/all.css?ver=7.9' media='all' />
<link rel='stylesheet' id='prime-college-style-css' href='https://prime.edu.np/wp-content/themes/prime-college/style.css?ver=1.0.0' media='all' />
<link rel='stylesheet' id='popup-maker-site-css' href='https://prime.edu.np/wp-content/plugins/popup-maker/assets/css/pum-site.min.css?ver=1.20.3' media='all' />
<style id='popup-maker-site-inline-css'>
/* Popup Google Fonts */
@import url('//fonts.googleapis.com/css?family=Montserrat:100');

/* Popup Theme 2307: Default Theme */
.pum-theme-2307, .pum-theme-default-theme { background-color: rgba( 255, 255, 255, 1.00 ) } 
.pum-theme-2307 .pum-container, .pum-theme-default-theme .pum-container { padding: 18px; border-radius: 0px; border: 1px none #000000; box-shadow: 1px 1px 3px 0px rgba( 2, 2, 2, 0.23 ); background-color: rgba( 249, 249, 249, 1.00 ) } 
.pum-theme-2307 .pum-title, .pum-theme-default-theme .pum-title { color: #000000; text-align: left; text-shadow: 0px 0px 0px rgba( 2, 2, 2, 0.23 ); font-family: inherit; font-weight: 400; font-size: 32px; font-style: normal; line-height: 36px } 
.pum-theme-2307 .pum-content, .pum-theme-default-theme .pum-content { color: #8c8c8c; font-family: inherit; font-weight: 400; font-style: inherit } 
.pum-theme-2307 .pum-content + .pum-close, .pum-theme-default-theme .pum-content + .pum-close { position: absolute; height: auto; width: auto; left: auto; right: 0px; bottom: auto; top: 0px; padding: 8px; color: #ffffff; font-family: inherit; font-weight: 400; font-size: 12px; font-style: inherit; line-height: 36px; border: 1px none #ffffff; border-radius: 0px; box-shadow: 1px 1px 3px 0px rgba( 2, 2, 2, 0.23 ); text-shadow: 0px 0px 0px rgba( 0, 0, 0, 0.23 ); background-color: rgba( 0, 183, 205, 1.00 ) } 

/* Popup Theme 2308: Light Box */
.pum-theme-2308, .pum-theme-lightbox { background-color: rgba( 0, 0, 0, 0.60 ) } 
.pum-theme-2308 .pum-container, .pum-theme-lightbox .pum-container { padding: 18px; border-radius: 3px; border: 8px solid #000000; box-shadow: 0px 0px 30px 0px rgba( 2, 2, 2, 1.00 ); background-color: rgba( 255, 255, 255, 1.00 ) } 
.pum-theme-2308 .pum-title, .pum-theme-lightbox .pum-title { color: #000000; text-align: left; text-shadow: 0px 0px 0px rgba( 2, 2, 2, 0.23 ); font-family: inherit; font-weight: 100; font-size: 32px; line-height: 36px } 
.pum-theme-2308 .pum-content, .pum-theme-lightbox .pum-content { color: #000000; font-family: inherit; font-weight: 100 } 
.pum-theme-2308 .pum-content + .pum-close, .pum-theme-lightbox .pum-content + .pum-close { position: absolute; height: 26px; width: 26px; left: auto; right: -13px; bottom: auto; top: -13px; padding: 0px; color: #ffffff; font-family: Arial; font-weight: 100; font-size: 24px; line-height: 24px; border: 2px solid #ffffff; border-radius: 26px; box-shadow: 0px 0px 15px 1px rgba( 2, 2, 2, 0.75 ); text-shadow: 0px 0px 0px rgba( 0, 0, 0, 0.23 ); background-color: rgba( 0, 0, 0, 1.00 ) } 

/* Popup Theme 2309: Enterprise Blue */
.pum-theme-2309, .pum-theme-enterprise-blue { background-color: rgba( 0, 0, 0, 0.70 ) } 
.pum-theme-2309 .pum-container, .pum-theme-enterprise-blue .pum-container { padding: 28px; border-radius: 5px; border: 1px none #000000; box-shadow: 0px 10px 25px 4px rgba( 2, 2, 2, 0.50 ); background-color: rgba( 255, 255, 255, 1.00 ) } 
.pum-theme-2309 .pum-title, .pum-theme-enterprise-blue .pum-title { color: #315b7c; text-align: left; text-shadow: 0px 0px 0px rgba( 2, 2, 2, 0.23 ); font-family: inherit; font-weight: 100; font-size: 34px; line-height: 36px } 
.pum-theme-2309 .pum-content, .pum-theme-enterprise-blue .pum-content { color: #2d2d2d; font-family: inherit; font-weight: 100 } 
.pum-theme-2309 .pum-content + .pum-close, .pum-theme-enterprise-blue .pum-content + .pum-close { position: absolute; height: 28px; width: 28px; left: auto; right: 8px; bottom: auto; top: 8px; padding: 4px; color: #ffffff; font-family: Times New Roman; font-weight: 100; font-size: 20px; line-height: 20px; border: 1px none #ffffff; border-radius: 42px; box-shadow: 0px 0px 0px 0px rgba( 2, 2, 2, 0.23 ); text-shadow: 0px 0px 0px rgba( 0, 0, 0, 0.23 ); background-color: rgba( 49, 91, 124, 1.00 ) } 

/* Popup Theme 2310: Hello Box */
.pum-theme-2310, .pum-theme-hello-box { background-color: rgba( 0, 0, 0, 0.75 ) } 
.pum-theme-2310 .pum-container, .pum-theme-hello-box .pum-container { padding: 30px; border-radius: 80px; border: 14px solid #81d742; box-shadow: 0px 0px 0px 0px rgba( 2, 2, 2, 0.00 ); background-color: rgba( 255, 255, 255, 1.00 ) } 
.pum-theme-2310 .pum-title, .pum-theme-hello-box .pum-title { color: #2d2d2d; text-align: left; text-shadow: 0px 0px 0px rgba( 2, 2, 2, 0.23 ); font-family: Montserrat; font-weight: 100; font-size: 32px; line-height: 36px } 
.pum-theme-2310 .pum-content, .pum-theme-hello-box .pum-content { color: #2d2d2d; font-family: inherit; font-weight: 100 } 
.pum-theme-2310 .pum-content + .pum-close, .pum-theme-hello-box .pum-content + .pum-close { position: absolute; height: auto; width: auto; left: auto; right: -30px; bottom: auto; top: -30px; padding: 0px; color: #2d2d2d; font-family: Times New Roman; font-weight: 100; font-size: 32px; line-height: 28px; border: 1px none #ffffff; border-radius: 28px; box-shadow: 0px 0px 0px 0px rgba( 2, 2, 2, 0.23 ); text-shadow: 0px 0px 0px rgba( 0, 0, 0, 0.23 ); background-color: rgba( 255, 255, 255, 1.00 ) } 

/* Popup Theme 2311: Cutting Edge */
.pum-theme-2311, .pum-theme-cutting-edge { background-color: rgba( 0, 0, 0, 0.50 ) } 
.pum-theme-2311 .pum-container, .pum-theme-cutting-edge .pum-container { padding: 18px; border-radius: 0px; border: 1px none #000000; box-shadow: 0px 10px 25px 0px rgba( 2, 2, 2, 0.50 ); background-color: rgba( 30, 115, 190, 1.00 ) } 
.pum-theme-2311 .pum-title, .pum-theme-cutting-edge .pum-title { color: #ffffff; text-align: left; text-shadow: 0px 0px 0px rgba( 2, 2, 2, 0.23 ); font-family: Sans-Serif; font-weight: 100; font-size: 26px; line-height: 28px } 
.pum-theme-2311 .pum-content, .pum-theme-cutting-edge .pum-content { color: #ffffff; font-family: inherit; font-weight: 100 } 
.pum-theme-2311 .pum-content + .pum-close, .pum-theme-cutting-edge .pum-content + .pum-close { position: absolute; height: 24px; width: 24px; left: auto; right: 0px; bottom: auto; top: 0px; padding: 0px; color: #1e73be; font-family: Times New Roman; font-weight: 100; font-size: 32px; line-height: 24px; border: 1px none #ffffff; border-radius: 0px; box-shadow: -1px 1px 1px 0px rgba( 2, 2, 2, 0.10 ); text-shadow: -1px 1px 1px rgba( 0, 0, 0, 0.10 ); background-color: rgba( 238, 238, 34, 1.00 ) } 

/* Popup Theme 2312: Framed Border */
.pum-theme-2312, .pum-theme-framed-border { background-color: rgba( 255, 255, 255, 0.50 ) } 
.pum-theme-2312 .pum-container, .pum-theme-framed-border .pum-container { padding: 18px; border-radius: 0px; border: 20px outset #dd3333; box-shadow: 1px 1px 3px 0px rgba( 2, 2, 2, 0.97 ) inset; background-color: rgba( 255, 251, 239, 1.00 ) } 
.pum-theme-2312 .pum-title, .pum-theme-framed-border .pum-title { color: #000000; text-align: left; text-shadow: 0px 0px 0px rgba( 2, 2, 2, 0.23 ); font-family: inherit; font-weight: 100; font-size: 32px; line-height: 36px } 
.pum-theme-2312 .pum-content, .pum-theme-framed-border .pum-content { color: #2d2d2d; font-family: inherit; font-weight: 100 } 
.pum-theme-2312 .pum-content + .pum-close, .pum-theme-framed-border .pum-content + .pum-close { position: absolute; height: 20px; width: 20px; left: auto; right: -20px; bottom: auto; top: -20px; padding: 0px; color: #ffffff; font-family: Tahoma; font-weight: 700; font-size: 16px; line-height: 18px; border: 1px none #ffffff; border-radius: 0px; box-shadow: 0px 0px 0px 0px rgba( 2, 2, 2, 0.23 ); text-shadow: 0px 0px 0px rgba( 0, 0, 0, 0.23 ); background-color: rgba( 0, 0, 0, 0.55 ) } 

/* Popup Theme 2313: Floating Bar - Soft Blue */
.pum-theme-2313, .pum-theme-floating-bar { background-color: rgba( 255, 255, 255, 0.00 ) } 
.pum-theme-2313 .pum-container, .pum-theme-floating-bar .pum-container { padding: 8px; border-radius: 0px; border: 1px none #000000; box-shadow: 1px 1px 3px 0px rgba( 2, 2, 2, 0.23 ); background-color: rgba( 238, 246, 252, 1.00 ) } 
.pum-theme-2313 .pum-title, .pum-theme-floating-bar .pum-title { color: #505050; text-align: left; text-shadow: 0px 0px 0px rgba( 2, 2, 2, 0.23 ); font-family: inherit; font-weight: 400; font-size: 32px; line-height: 36px } 
.pum-theme-2313 .pum-content, .pum-theme-floating-bar .pum-content { color: #505050; font-family: inherit; font-weight: 400 } 
.pum-theme-2313 .pum-content + .pum-close, .pum-theme-floating-bar .pum-content + .pum-close { position: absolute; height: 18px; width: 18px; left: auto; right: 5px; bottom: auto; top: 50%; padding: 0px; color: #505050; font-family: Sans-Serif; font-weight: 700; font-size: 15px; line-height: 18px; border: 1px solid #505050; border-radius: 15px; box-shadow: 0px 0px 0px 0px rgba( 2, 2, 2, 0.00 ); text-shadow: 0px 0px 0px rgba( 0, 0, 0, 0.00 ); background-color: rgba( 255, 255, 255, 0.00 ); transform: translate(0, -50%) } 

/* Popup Theme 2314: Content Only - For use with page builders or block editor */
.pum-theme-2314, .pum-theme-content-only { background-color: rgba( 0, 0, 0, 0.70 ) } 
.pum-theme-2314 .pum-container, .pum-theme-content-only .pum-container { padding: 0px; border-radius: 0px; border: 1px none #000000; box-shadow: 0px 0px 0px 0px rgba( 2, 2, 2, 0.00 ) } 
.pum-theme-2314 .pum-title, .pum-theme-content-only .pum-title { color: #000000; text-align: left; text-shadow: 0px 0px 0px rgba( 2, 2, 2, 0.23 ); font-family: inherit; font-weight: 400; font-size: 32px; line-height: 36px } 
.pum-theme-2314 .pum-content, .pum-theme-content-only .pum-content { color: #8c8c8c; font-family: inherit; font-weight: 400 } 
.pum-theme-2314 .pum-content + .pum-close, .pum-theme-content-only .pum-content + .pum-close { position: absolute; height: 18px; width: 18px; left: auto; right: 7px; bottom: auto; top: 7px; padding: 0px; color: #000000; font-family: inherit; font-weight: 700; font-size: 20px; line-height: 20px; border: 1px none #ffffff; border-radius: 15px; box-shadow: 0px 0px 0px 0px rgba( 2, 2, 2, 0.00 ); text-shadow: 0px 0px 0px rgba( 0, 0, 0, 0.00 ); background-color: rgba( 255, 255, 255, 0.00 ) } 

#pum-2316 {z-index: 1999999999}
#pum-2455 {z-index: 1999999999}
#pum-2315 {z-index: 1999999999}

</style>
<script src="https://prime.edu.np/wp-includes/js/jquery/jquery.min.js?ver=3.7.1" id="jquery-core-js"></script>
<script src="https://prime.edu.np/wp-includes/js/jquery/jquery-migrate.min.js?ver=3.4.1" id="jquery-migrate-js"></script>
<link rel="https://api.w.org/" href="https://prime.edu.np/wp-json/" /><link rel="alternate" title="JSON" type="application/json" href="https://prime.edu.np/wp-json/wp/v2/pages/7" /><link rel="EditURI" type="application/rsd+xml" title="RSD" href="https://prime.edu.np/xmlrpc.php?rsd" />
<meta name="generator" content="WordPress 6.7.1" />
<link rel='shortlink' href='https://prime.edu.np/' />
<link rel="alternate" title="oEmbed (JSON)" type="application/json+oembed" href="https://prime.edu.np/wp-json/oembed/1.0/embed?url=https%3A%2F%2Fprime.edu.np%2F" />
<link rel="alternate" title="oEmbed (XML)" type="text/xml+oembed" href="https://prime.edu.np/wp-json/oembed/1.0/embed?url=https%3A%2F%2Fprime.edu.np%2F&#038;format=xml" />
		<style id="wp-custom-css">
			header.fixed-header {

z-index:9999;
}


.sc-1au8ryl-0.dmopMx {
    display: none;
}
.sc-sbsi7l-0.cLcbjv{
	display:none;
}



/* ---Media Query---- */
@media (max-width: 767.98px) {
	.club-item.seven{
		padding-bottom:40px;
	}
}

.justified-text {
    text-align: justify;
}		</style>
			
	<!-- Google tag (gtag.js) -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G- E340X0X4Q2"></script>
<!--<script src="https://prime.edu.np/wp-content/themes/prime-college/assets/js/jquery-3.7.0.min.js"></script>-->
<script>
window.dataLayer = window.dataLayer || []; function gtag(){dataLayer.push(arguments);} gtag('js', new Date());

gtag('config', 'G-E340X0X4Q2');
</script>

</head>

<body class="home page-template-default page page-id-7">
   <!-- Start Top Header -->
<div class="top-header">
  <div class="container-fluid">
    <div class="row">
      <div class="col-12 col-sm-9 col-md-8">
        <ul>
          <li><span class="icon"><i class="fa-solid fa-phone"></i></span><a href="tel:01-4961690">01-4961690</a> | <a href="tel:01-4970072">01-4970072</a></li>
          <li><span class="icon"><i class="fa-solid fa-envelope"></i></span><a href="/cdn-cgi/l/email-protection#afc6c1c9c0efdfddc6c2ca81cacbda81c1df"><span class="__cf_email__" data-cfemail="1970777f7659696b70747c377c7d6c377769">[email&#160;protected]</span></a></li>
        </ul>
      </div>
      <div class="col-sm-3 col-md-4 d-none d-sm-block">
        <ul class="si-wrap text-end">
        <li><a href="https://www.facebook.com/primecollegenp" target="_blank"><i class="fa-brands fa-facebook-f"></i></a></li>
          <li><a href="https://www.youtube.com/user/primecollege1" target="_blank"><i class="fa-brands fa-youtube"></i></a></li>
          <li><a href="https://www.instagram.com/prime__college/?hl=en" target="_blank"><i class="fa-brands fa-instagram"></i></a></li>
          <li><a href="https://np.linkedin.com/company/prime-college-nepal" target="_blank"><i class="fa-brands fa-linkedin-in"></i></a></li>
          <li><a href="https://www.tiktok.com/@prime_college" target="_blank"><i class="fa-brands fa-tiktok"></i></a></li>
        </ul>
      </div>
    </div>
  </div>
</div>
<!-- End Top Header -->

<!-- Start Header -->
<header>
  <nav class="navbar navbar-expand-lg navbar-dark" aria-label="Fourth navbar example">
    <div class="container-fluid">
      <a class="navbar-brand" href="https://prime.edu.np"><img src="https://prime.edu.np/wp-content/uploads/2023/08/prime-logo.svg" alt="logo"></a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
      <i class="fa-solid fa-bars-staggered"></i>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExample04">
          <ul id="menu-primary-menu" class="navbar-nav ms-auto mb-2 mb-md-0"><li id="menu-item-487" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-487"><a href="https://prime.edu.np/about/">Who We Are</a></li>
<li id="menu-item-488" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-488"><a href="https://prime.edu.np/programs/">Our Programs</a></li>
<li id="menu-item-489" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-489"><a href="https://prime.edu.np/why-join-prime/">Why Join Prime</a></li>
<li id="menu-item-1443" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1443"><a href="https://prime.edu.np/life-at-prime/">Life at Prime</a></li>
<li id="menu-item-491" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-491"><a href="https://prime.edu.np/contact-us/">Contact Us</a></li>
<li id="menu-item-492" class="btn btn-primary menu-item menu-item-type-post_type menu-item-object-page menu-item-492"><a href="https://prime.edu.np/apply-now/">Apply Now</a></li>
</ul>      
      </div>
      <div class="bar-wrap">
          <a href="#" class="bar"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/bars.svg" alt="bar" class="bar-icon"></a>
          <div class="mega-menu-wrap">
  <!--<div class="mega-close">-->
  <!--<i class="fa-solid fa-xmark"></i>-->
  <!--</div>-->
  <div class="mega-menu-inner">
  <div class="container">
    <div class="row">
      <div class="col-sm-6 col-md-4 col-lg-3">
        <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/about">Who We Are?</a></h4>
          <ul id="menu-who-we-are" class="menu"><li id="menu-item-517" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-517"><a href="https://prime.edu.np/about/">About Us</a></li>
<li id="menu-item-518" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-518"><a href="https://prime.edu.np/team/">Know Our Team</a></li>
</ul>        </div>
        <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/programs">Our Programs</a></h4>
        <ul id="menu-our-programs" class="menu"><li id="menu-item-529" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-529"><a href="https://prime.edu.np/program/bim/">BIM</a></li>
<li id="menu-item-524" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-524"><a href="https://prime.edu.np/program/bachelor-of-business-administration/">BBA</a></li>
<li id="menu-item-525" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-525"><a href="https://prime.edu.np/program/bachelor-of-business-studies/">BBS</a></li>
<li id="menu-item-527" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-527"><a href="https://prime.edu.np/program/bachelors-of-science-in-csit/">BSc. CSIT</a></li>
<li id="menu-item-528" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-528"><a href="https://prime.edu.np/program/bbm/">BBM</a></li>
<li id="menu-item-526" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-526"><a href="https://prime.edu.np/program/bachelor-of-computer-applications/">BCA</a></li>
<li id="menu-item-530" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-530"><a href="https://prime.edu.np/program/mbs/">MBS</a></li>
</ul>        </div>
        <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/life-at-prime/">Life at Prime</a></h4>
         <ul id="menu-life-at-prime" class="menu"><li id="menu-item-544" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-544"><a href="https://prime.edu.np/events/">News and Events</a></li>
<li id="menu-item-1438" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1438"><a href="https://prime.edu.np/prime-blog/">Prime Blogs</a></li>
<li id="menu-item-2516" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-2516"><a href="https://prime.edu.np/prime-innovators-hub/">Prime Innovators Hub</a></li>
<li id="menu-item-758" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-758"><a href="https://prime.edu.np/prime-in-picture/">Prime In Pictures</a></li>
</ul>        </div>

        
      </div>
      <div class="col-sm-6 col-md-4 col-lg-3">
        <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/why-join-prime/">Why Join Prime ?</a></h4>
          <ul id="menu-why-join-prime" class="menu"><li id="menu-item-672" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-672"><a href="https://prime.edu.np/infrastructure/">Progressive Infrastructure</a></li>
<li id="menu-item-736" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-736"><a href="https://prime.edu.np/pride-of-prime/">Pride Of Prime</a></li>
<li id="menu-item-1199" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1199"><a href="https://prime.edu.np/what-makes-prime-special/">What Makes Prime Special</a></li>
<li id="menu-item-1291" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1291"><a href="https://prime.edu.np/read-our-story/">Read Our Story</a></li>
</ul>        </div>
		    <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/mlrc/">Mathema Learning Resource Center(MLRC)</a></h4>
          <ul id="menu-mathema-learning-resource-center-mlrc" class="menu"><li id="menu-item-950" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-950"><a href="https://prime.edu.np/mlrc/">Value Added Course</a></li>
<li id="menu-item-949" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-949"><a href="https://prime.edu.np/mlrc/">Student Support Division</a></li>
<li id="menu-item-1200" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1200"><a href="https://prime.edu.np/student-club/">Student’s Club</a></li>
</ul>        </div>
		     <div class="mega-menu-item">
		   <h4><a href="#">Prime Alumni Association</a></h4>
          <ul id="menu-prime-alumni-association" class="menu"><li id="menu-item-650" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-650"><a href="#">Form</a></li>
<li id="menu-item-651" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-651"><a href="#">Our Alumni</a></li>
</ul>        </div>
        
      </div>
      <div class="col-sm-6 col-md-4 col-lg-3">
		  <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/career/">Prime Career Center</a></h4>
          <ul id="menu-prime-career-center" class="menu"><li id="menu-item-1254" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1254"><a href="https://prime.edu.np/career/">Student Internship Program</a></li>
<li id="menu-item-1255" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1255"><a href="https://prime.edu.np/career/">Career Building Program</a></li>
<li id="menu-item-1256" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1256"><a href="https://prime.edu.np/prime-career-partners/">Prime Career Center Partners</a></li>
</ul>        </div>
<div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/eso/">Ethics and Standard Office</a></h4>
          <ul id="menu-ethics-and-standard-office" class="menu"><li id="menu-item-969" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-969"><a href="https://prime.edu.np/eso/">Prime Wellness Center</a></li>
</ul>        </div>
        
       
         
       
        <div class="mega-menu-item">
          <h4><a href="#">Our Partners</a></h4>
         <ul id="menu-our-partners" class="menu"><li id="menu-item-606" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-606"><a href="https://prime.edu.np/prime-career-partners/">Prime Career Partners</a></li>
<li id="menu-item-605" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-605"><a href="https://prime.edu.np/world-wide-partners/">World Wide Partners</a></li>
<li id="menu-item-604" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-604"><a href="https://prime.edu.np/prime-privilege-partners/">Prime Privilege Partners</a></li>
</ul>        </div>
         <div class="mega-menu-item">
          <h4><a href="#">Hall Booking</a></h4>
           <ul id="menu-seminar-hall-booking" class="menu"><li id="menu-item-2224" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-2224"><a href="https://prime.edu.np/hall-booking/">Seminar Hall Booking</a></li>
<li id="menu-item-2223" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-2223"><a href="https://prime.edu.np/room-booking/">Multipurpose Room Booking</a></li>
</ul>        </div>
        
     
      </div>
      <div class="col-sm-6 col-md-4 col-lg-3">

                        <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/vacancy/">Join Our Team</a></h4>
          
        </div>
        
                                <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/notices/">College Notices</a></h4>
          
        </div>
                		   

                <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/faq/">FAQ </a></h4>
          
        </div>
		  <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/character-certificate-form/">Character Certificate Form</a></h4>
          
        </div>
        <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/new-id-card-issuance/">New ID Card Issuance Form</a></h4>
          
        </div>
        <div class="mega-menu-item">
          <h4><a href="https://prime.paathshala.com.np/Login.aspx" target="_blank">Prime Online Portal Login</a></h4>
          
        </div>
        <div class="mega-menu-item">
          <h4><a href="https://prime.edu.np/contact-us/">Contact us </a></h4>
          
        </div>
   
         <div class="mega-menu-item">
          <h4><a href="https://forms.office.com/r/q7Sv1Hc4mw" target="_blank">Event Registration Form</a></h4>
          
        </div>  <div class="mega-menu-item">
          <h4><a href="https://forms.office.com/r/rvefAsv5QQ" target="_blank">Tour and Travel Form</a></h4>
          
        </div>
       
      </div>
      </div>
  </div>
  </div>
  <div class="apply-cta-wrap">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-10 col-lg-8">
          <div class="d-md-flex align-items-center justify-content-between">
            <div class="mb-4 mb-md-0">
              <h4 class="mb-1">Apply Now</h4>
              <small>Would you like to apply for the admission session?</small>
            </div>
            <div>
              <a href="https://prime.edu.np/apply-now" class="btn btn-outline-light d-block d-sm-inline-block">Apply</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
      </div>
      
      <a href="#" class="search-trigger"><i class="fa-solid fa-magnifying-glass"></i></a>
<!--      <form class="search-bar-wrapper">-->
<!--          <div class="search-bar-inner">-->
<!--  <div class="input-wrapper">-->
<!--    <input type="text" placeholder="Search Here..." class="input-field">-->
<!--    <button type="submit" class="search-icon">-->
<!--      <img src="https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/search-1024.png" width="26" height="26" alt="search -->
<!--                bar">-->
<!--    </button>-->
<!--  </div>-->
<!--  </div>-->
<!--</form>-->
    </div>
  </nav>
</header>
<!-- End Header -->

<div class="search-box-wrap">
    <form>
        <input type="text"  value="" name="s" id="s" placeholder="Search here...." class="form-control" autofocus="">
    </form>
</div>

<!-- ----------Mega Menu--------- -->

<!-- Start Banner Section -->
<div class="banner-section">
  <!-- Slider main container -->
  <div class="swiper banner-slider">
    <!-- Additional required wrapper -->
    <div class="swiper-wrapper">
      <!-- Slides -->
             <div class="swiper-slide" style="background-image: url('https://prime.edu.np/wp-content/uploads/2023/08/1.-Initiate-scaled.jpg');">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <div class="banner-content-wrap">
                <div class="banner-content">
                  <h1 class="line-1 anim-typewriter">Initiate...</h1>
                  <!-- <p>Prime College is the first IT enabled college of Nepal</p> -->
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
            <div class="swiper-slide" style="background-image: url('https://prime.edu.np/wp-content/uploads/2023/08/2.-Explore-scaled.jpg');">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <div class="banner-content-wrap">
                <div class="banner-content">
                  <h1 class="line-1 anim-typewriter">Explore...</h1>
                  <!-- <p>Prime College is the first IT enabled college of Nepal</p> -->
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
            <div class="swiper-slide" style="background-image: url('https://prime.edu.np/wp-content/uploads/2023/08/3.-Innovate-scaled.jpg');">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <div class="banner-content-wrap">
                <div class="banner-content">
                  <h1 class="line-1 anim-typewriter">Innovate...</h1>
                  <!-- <p>Prime College is the first IT enabled college of Nepal</p> -->
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
       
    </div>

    <!-- If we need navigation buttons -->
    <div class="swiper-button-prev"></div>
    <div class="swiper-button-next"></div>

  </div>
</div>
<!-- End Banner Section -->
<!-- Start Prime Experience Center -->
<div class="prime-experience-section block pb-0">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="section-head">
          <h2 class="section-title">
           Get the Taste of <a href="https://prime.edu.np/prime-in-picture"><span>Prime</span></a> Experience!          </h2>
          <div class="d-sm-flex justify-content-between">
                        </div>
        </div>
      </div>
    </div>
  </div>
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-12">
        <div class="exp-card-wrap">
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2023/08/20230114_130656-scaled.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-123-of-909-scaled.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2024/03/419737599_387032610787660_4127246294101307592_n.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2023/08/318427742_2079352288938708_7122442755432514774_n.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-975-of-592-scaled.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2023/08/335945192_224093113494929_836574114928973099_n.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-61-of-909-scaled.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2024/05/441149137_419922100832044_3384739801662751191_n.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2023/08/333049163_747544856688967_5186421015281104183_n.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2024/03/420173062_387030260787895_1599942019332965253_n.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2024/03/417591592_387029090788012_8119324254296562582_n-edited.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2023/08/331910911_203118139000523_305516247075393383_n.jpg" alt="#">
                    </div>
            </div>
                        <div class="exp-card">
                    <div class="img">
                        <img src="https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-773-of-909-scaled.jpg" alt="#">
                    </div>
            </div>
                      
        </div>
      </div>
    </div>
  </div>
</div>
<!-- End Prime Experience Center -->


<!-- Start Our Program -->
<div class="our-program-section block">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="section-head">
          <h2 class="section-title">
            Our Programs
          </h2>
        </div>
        <div class="swiper our-program-slider">
          <!-- Additional required wrapper -->
          <div class="swiper-wrapper">
            <!-- Slides -->
                         <div class="swiper-slide">
              <div class="program-card card">
                <div class="card-img">
                 <img width="1707" height="2560" src="https://prime.edu.np/wp-content/uploads/2023/07/BSc.-CSIT-Program-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/BSc.-CSIT-Program-scaled.jpg 1707w, https://prime.edu.np/wp-content/uploads/2023/07/BSc.-CSIT-Program-200x300.jpg 200w, https://prime.edu.np/wp-content/uploads/2023/07/BSc.-CSIT-Program-683x1024.jpg 683w, https://prime.edu.np/wp-content/uploads/2023/07/BSc.-CSIT-Program-768x1152.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/07/BSc.-CSIT-Program-1024x1536.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/BSc.-CSIT-Program-1365x2048.jpg 1365w" sizes="(max-width: 1707px) 100vw, 1707px" />                </div>
                <div class="card-body">
                  <div class="faculty">BSc.CSIT</div>
                  <h4 class="equal-height"><a href="https://prime.edu.np/program/bachelors-of-science-in-csit/">Bachelor of Science in Computer Science and Information Technology</a></h4>
                  <a href="https://prime.edu.np/program/bachelors-of-science-in-csit/" class="view-link">View Detail</a>
                </div>
                <a href="https://prime.edu.np/program/bachelors-of-science-in-csit/" class="program-card-detail">
                  <h4>Bachelor of Science in Computer Science and Information Technology</h4>
                  <div class="program-feature">
                     <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/graduation-cal.png" alt="#"></span>
                                <div class="info">
                                    <p>Semester/Year</p>
                                    <h5>8 Semesters, 4  Years</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/clock.png" alt="#"></span>
								
                                <div class="info">
                                    <p>Credit Hours</p>
                                    <h5>126 Hrs</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/sun.png" alt="#"></span>
                                <div class="info">
                                    <p>Timing</p>
                                    <h5>Morning</h5>
                                </div>
                            </div>
                            <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/note.png" alt="#"></span>
                                <div class="info">
                                    <p>Entrance Exam</p>
                                    <h5>IOST</h5>
                                </div>
                            </div>

                  </div>
<!--                   <a href="https://prime.edu.np/program/bachelors-of-science-in-csit/" class="view-link">View Detail</a> -->
                </a>
              </div>
            </div>
                       <div class="swiper-slide">
              <div class="program-card card">
                <div class="card-img">
                 <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/07/BCA-Program-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/BCA-Program-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/07/BCA-Program-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/07/BCA-Program-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/BCA-Program-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/07/BCA-Program-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/07/BCA-Program-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />                </div>
                <div class="card-body">
                  <div class="faculty">BCA</div>
                  <h4 class="equal-height"><a href="https://prime.edu.np/program/bachelor-of-computer-applications/">Bachelor of Computer Applications</a></h4>
                  <a href="https://prime.edu.np/program/bachelor-of-computer-applications/" class="view-link">View Detail</a>
                </div>
                <a href="https://prime.edu.np/program/bachelor-of-computer-applications/" class="program-card-detail">
                  <h4>Bachelor of Computer Applications</h4>
                  <div class="program-feature">
                     <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/graduation-cal.png" alt="#"></span>
                                <div class="info">
                                    <p>Semester/Year</p>
                                    <h5>8 Semesters, 4 Years</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/clock.png" alt="#"></span>
								
                                <div class="info">
                                    <p>Credit Hours</p>
                                    <h5>126 Hrs</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/sun.png" alt="#"></span>
                                <div class="info">
                                    <p>Timing</p>
                                    <h5>Morning</h5>
                                </div>
                            </div>
                            <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/note.png" alt="#"></span>
                                <div class="info">
                                    <p>Entrance Exam</p>
                                    <h5>BCA </h5>
                                </div>
                            </div>

                  </div>
<!--                   <a href="https://prime.edu.np/program/bachelor-of-computer-applications/" class="view-link">View Detail</a> -->
                </a>
              </div>
            </div>
                       <div class="swiper-slide">
              <div class="program-card card">
                <div class="card-img">
                 <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/07/BBA-Program-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/BBA-Program-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/07/BBA-Program-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/07/BBA-Program-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/BBA-Program-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/07/BBA-Program-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/07/BBA-Program-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />                </div>
                <div class="card-body">
                  <div class="faculty">BBA</div>
                  <h4 class="equal-height"><a href="https://prime.edu.np/program/bachelor-of-business-administration/">Bachelor of Business Administration</a></h4>
                  <a href="https://prime.edu.np/program/bachelor-of-business-administration/" class="view-link">View Detail</a>
                </div>
                <a href="https://prime.edu.np/program/bachelor-of-business-administration/" class="program-card-detail">
                  <h4>Bachelor of Business Administration</h4>
                  <div class="program-feature">
                     <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/graduation-cal.png" alt="#"></span>
                                <div class="info">
                                    <p>Semester/Year</p>
                                    <h5>8 Semesters, 4  Years</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/clock.png" alt="#"></span>
								
                                <div class="info">
                                    <p>Credit Hours</p>
                                    <h5>120  Hrs</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/sun.png" alt="#"></span>
                                <div class="info">
                                    <p>Timing</p>
                                    <h5>Morning / Day</h5>
                                </div>
                            </div>
                            <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/note.png" alt="#"></span>
                                <div class="info">
                                    <p>Entrance Exam</p>
                                    <h5>CMAT </h5>
                                </div>
                            </div>

                  </div>
<!--                   <a href="https://prime.edu.np/program/bachelor-of-business-administration/" class="view-link">View Detail</a> -->
                </a>
              </div>
            </div>
                       <div class="swiper-slide">
              <div class="program-card card">
                <div class="card-img">
                 <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/07/BIM-Program-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/BIM-Program-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/07/BIM-Program-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/07/BIM-Program-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/BIM-Program-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/07/BIM-Program-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/07/BIM-Program-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />                </div>
                <div class="card-body">
                  <div class="faculty">BIM</div>
                  <h4 class="equal-height"><a href="https://prime.edu.np/program/bim/">Bachelor of Information Management</a></h4>
                  <a href="https://prime.edu.np/program/bim/" class="view-link">View Detail</a>
                </div>
                <a href="https://prime.edu.np/program/bim/" class="program-card-detail">
                  <h4>Bachelor of Information Management</h4>
                  <div class="program-feature">
                     <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/graduation-cal.png" alt="#"></span>
                                <div class="info">
                                    <p>Semester/Year</p>
                                    <h5>8 Semesters, 4 Years</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/clock.png" alt="#"></span>
								
                                <div class="info">
                                    <p>Credit Hours</p>
                                    <h5>126 Hrs</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/sun.png" alt="#"></span>
                                <div class="info">
                                    <p>Timing</p>
                                    <h5>Day</h5>
                                </div>
                            </div>
                            <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/note.png" alt="#"></span>
                                <div class="info">
                                    <p>Entrance Exam</p>
                                    <h5> CMAT </h5>
                                </div>
                            </div>

                  </div>
<!--                   <a href="https://prime.edu.np/program/bim/" class="view-link">View Detail</a> -->
                </a>
              </div>
            </div>
                       <div class="swiper-slide">
              <div class="program-card card">
                <div class="card-img">
                 <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/07/BBM-Program-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/BBM-Program-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/07/BBM-Program-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/07/BBM-Program-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/BBM-Program-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/07/BBM-Program-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/07/BBM-Program-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />                </div>
                <div class="card-body">
                  <div class="faculty">BBM</div>
                  <h4 class="equal-height"><a href="https://prime.edu.np/program/bbm/">Bachelor of Business Management</a></h4>
                  <a href="https://prime.edu.np/program/bbm/" class="view-link">View Detail</a>
                </div>
                <a href="https://prime.edu.np/program/bbm/" class="program-card-detail">
                  <h4>Bachelor of Business Management</h4>
                  <div class="program-feature">
                     <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/graduation-cal.png" alt="#"></span>
                                <div class="info">
                                    <p>Semester/Year</p>
                                    <h5>8 Semesters, 4  Years</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/clock.png" alt="#"></span>
								
                                <div class="info">
                                    <p>Credit Hours</p>
                                    <h5>120 Hrs</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/sun.png" alt="#"></span>
                                <div class="info">
                                    <p>Timing</p>
                                    <h5>Morning</h5>
                                </div>
                            </div>
                            <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/note.png" alt="#"></span>
                                <div class="info">
                                    <p>Entrance Exam</p>
                                    <h5>CMAT</h5>
                                </div>
                            </div>

                  </div>
<!--                   <a href="https://prime.edu.np/program/bbm/" class="view-link">View Detail</a> -->
                </a>
              </div>
            </div>
                       <div class="swiper-slide">
              <div class="program-card card">
                <div class="card-img">
                 <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/08/BBS-Program-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/08/BBS-Program-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/08/BBS-Program-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/08/BBS-Program-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/08/BBS-Program-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/08/BBS-Program-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/08/BBS-Program-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />                </div>
                <div class="card-body">
                  <div class="faculty">BBS</div>
                  <h4 class="equal-height"><a href="https://prime.edu.np/program/bachelor-of-business-studies/">Bachelor of Business Studies</a></h4>
                  <a href="https://prime.edu.np/program/bachelor-of-business-studies/" class="view-link">View Detail</a>
                </div>
                <a href="https://prime.edu.np/program/bachelor-of-business-studies/" class="program-card-detail">
                  <h4>Bachelor of Business Studies</h4>
                  <div class="program-feature">
                     <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/graduation-cal.png" alt="#"></span>
                                <div class="info">
                                    <p>Semester/Year</p>
                                    <h5>4 Years</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/sun.png" alt="#"></span>
                                <div class="info">
                                    <p>Timing</p>
                                    <h5>Morning</h5>
                                </div>
                            </div>
                            <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/note.png" alt="#"></span>
                                <div class="info">
                                    <p>Entrance Exam</p>
                                    <h5>No entrance</h5>
                                </div>
                            </div>

                  </div>
<!--                   <a href="https://prime.edu.np/program/bachelor-of-business-studies/" class="view-link">View Detail</a> -->
                </a>
              </div>
            </div>
                       <div class="swiper-slide">
              <div class="program-card card">
                <div class="card-img">
                 <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/07/MBS-Program-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/MBS-Program-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/07/MBS-Program-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/07/MBS-Program-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/MBS-Program-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/07/MBS-Program-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/07/MBS-Program-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />                </div>
                <div class="card-body">
                  <div class="faculty">MBS</div>
                  <h4 class="equal-height"><a href="https://prime.edu.np/program/mbs/">Master of Business Studies</a></h4>
                  <a href="https://prime.edu.np/program/mbs/" class="view-link">View Detail</a>
                </div>
                <a href="https://prime.edu.np/program/mbs/" class="program-card-detail">
                  <h4>Master of Business Studies</h4>
                  <div class="program-feature">
                     <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/graduation-cal.png" alt="#"></span>
                                <div class="info">
                                    <p>Semester/Year</p>
                                    <h5>4 Semesters, 2  Years</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/clock.png" alt="#"></span>
								
                                <div class="info">
                                    <p>Credit Hours</p>
                                    <h5>60 Hrs</h5>
                                </div>
                            </div>
					                              <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/sun.png" alt="#"></span>
                                <div class="info">
                                    <p>Timing</p>
                                    <h5>Morning</h5>
                                </div>
                            </div>
                            <div class="program-feature-item">
                                <span class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/note.png" alt="#"></span>
                                <div class="info">
                                    <p>Entrance Exam</p>
                                    <h5>CMAT(MBS)</h5>
                                </div>
                            </div>

                  </div>
<!--                   <a href="https://prime.edu.np/program/mbs/" class="view-link">View Detail</a> -->
                </a>
              </div>
            </div>
                     </div>
          <!-- If we need navigation buttons -->
          <div class="swiper-button-prev"></div>
          <div class="swiper-button-next"></div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- End Our Program -->

<!-- Start Prime In Number -->
<div class="prime-in-number block" style="background-image: url('https://prime.edu.np/wp-content/themes/prime-college/assets/img/prime-num-bg.jpg');">
  <div class="container position-relative">
    <div class="row">
      <div class="col-md-12">
        <div class="section-head">
          <h2 class="section-title text-center">Prime in Numbers</h2>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <div class="number-hex-wrap">
          <div class="grid">
            <div class="col1">
              <div class="hex d-none d-md-block">
                <div class="hex-inner">
                  <img src="https://prime.edu.np/wp-content/uploads/2025/01/24.png" alt="">
                  <p>Years of Excellence</p>
                </div>
              </div>
            </div>
            <div class="col2">
              <div class="hex">
                <div class="hex-inner">
                  <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/book.svg" alt="">
                  <h5>7</h5>
                  <p>Programs Launched</p>
                </div>
              </div>
              <div class="hex">
                <div class="hex-inner">
                  <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/cap.svg" alt="">
                  <h5>4000+</h5>
                  <p>graduates from 7 programs in 20 years</p>
                </div>
              </div>
            </div>
            <div class="col3">
            <div class="hex d-md-none">
                <div class="hex-inner">
                  <img src="https://prime.edu.np/wp-content/uploads/2025/01/24.png" alt="">
                  <p>Years of Excellence</p>
                </div>
              </div>
              <div class="hex mid-hex">
                <div class="hex-inner">
                  <div class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/graduate.svg" alt="#"></div>
                  <div class="content">
                    <h5>25+</h5>
                    <p>TU Toppers in the Last 10 Years</p>
                  </div>
                </div>
              </div>
              <div class="hex d-md-none">
                <div class="hex-inner">
                  <img src="https://prime.edu.np/wp-content/uploads/2023/08/7.svg" alt="">
                  <p>Clubs established grown to over <strong>1000</strong> members</p>
                </div>
              </div>
            </div>
            <div class="col4">
              <div class="hex">
                <div class="hex-inner">
                  <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/trophy.svg" alt="">
                  <h5>50+</h5>
                  <p>Awards &amp; Competitions Won by Prime College</p>
                </div>
              </div>
              <div class="hex">
                <div class="hex-inner">
                  <div class="icon"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/graduate.svg" alt="#"></div>
                  <div class="content">
                    <h5>500+</h5>
                    <p>Distinctions in the last 5 years</p>
                  </div>
                </div>
              </div>
            </div>
            <div class="col5">
              <div class="hex d-none d-md-block">
                <div class="hex-inner">
                  <img src="https://prime.edu.np/wp-content/uploads/2023/08/7.svg" alt="">
                  <p>Clubs established grown to over <strong>1000</strong> members</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- End Prime In Number -->

<div class="chart-section block">
  <div class="container">
    <div class="row align-items-center">
      <div class="col-md-7 col-lg-8">
        <div class="chart-wrap">
          <div class="mid-circle-wrap">
            <div class="mid-circle"> Why Join Prime?</div>
          </div>
          <div class="pie-wrap">
          <div id="one" class="pie one">
            <a href="https://prime.edu.np/mlrc/"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/pie-shape2.png" alt=""></a>
          </div>
          </div>
          <div class="pie-wrap">
          <div id="two" class="pie two"><a href="https://prime.edu.np/career/"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/pie-shape3.png" alt=""></a>
          </div>
          </div>
          <div class="pie-wrap">
          <div id="three" class="pie three"><a href="https://prime.edu.np/eso/"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/pie-shape4.png" alt=""></a>
          </div></div>
          <div class="pie-wrap">
          <div id="four" class="pie four"><a href="https://prime.edu.np/"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/pie-shape5.png" alt=""></a></div></div>
            <div class="pie-wrap">
          <div id="five" class="pie five"><a href="https://prime.edu.np/team/"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/pie-shape6.png" alt=""></a></div></div>
            <div class="pie-wrap">
          <div id="six" class="pie six"><a href="https://prime.edu.np/"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/pie-shape7.png" alt="#"></a></div></div>
            <div class="pie-wrap">
          <div id="seven" class="pie seven"><a href="https://prime.edu.np/infrastructure/"><img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/pie-shape1.png" alt=""></a></div></div>
        </div>
        
      </div>
      <div class="col-md-5 col-lg-4">
        <div class="chart-content-wrap position-relative">
            <div class="arrow-icon">
              <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/arrow.png"/>
          </div>
                      <div id="content-one" class="card card-content">
            <div class="card-img">
              <img src="https://prime.edu.np/wp-content/uploads/2023/08/GOP_2470-Edited-scaled.jpg" alt="#">
            </div>
            <div class="card-body">
              <h4>Mathema Learning Resource Center</h4>
              <ul>
<li>Boost your skills with Value Added Courses</li>
<li> Get involved with the Prime Clubs</li>
</ul>
              <a href="https://prime.edu.np/mlrc/" class="btn btn-sm btn-light">View Detail</a>
            </div>
          </div>
                     <div id="content-two" class="card card-content">
            <div class="card-img">
              <img src="https://prime.edu.np/wp-content/uploads/2023/08/PCC-1-scaled.jpg" alt="#">
            </div>
            <div class="card-body">
              <h4>Prime Career Center</h4>
              <p>Job placement offers that match your skillset</p>
              <a href="https://prime.edu.np/career/" class="btn btn-sm btn-light">View Detail</a>
            </div>
          </div>
                     <div id="content-three" class="card card-content">
            <div class="card-img">
              <img src="https://prime.edu.np/wp-content/uploads/2023/08/ESO-1-scaled.jpg" alt="#">
            </div>
            <div class="card-body">
              <h4>Prime Wellness Center</h4>
              <p>Embracing mental wellness together: We care about you.</p>
              <a href="https://prime.edu.np/eso/" class="btn btn-sm btn-light">View Detail</a>
            </div>
          </div>
                     <div id="content-four" class="card card-content">
            <div class="card-img">
              <img src="https://prime.edu.np/wp-content/uploads/2023/08/GOP_2480-Edited-scaled.jpg" alt="#">
            </div>
            <div class="card-body">
              <h4>Engaging Co-Curricular Activities</h4>
              <p>Experience the extravagance of our activities.</p>
              <a href="https://prime.edu.np/student-%20club/" class="btn btn-sm btn-light">View Detail</a>
            </div>
          </div>
                     <div id="content-five" class="card card-content">
            <div class="card-img">
              <img src="https://prime.edu.np/wp-content/uploads/2023/08/GOP_2490-Edited-scaled.jpg" alt="#">
            </div>
            <div class="card-body">
              <h4>Support along the Way</h4>
              <p>Friendly Faculties, Lifelong Mentors.</p>
              <a href="https://prime.edu.np/team/" class="btn btn-sm btn-light">View Detail</a>
            </div>
          </div>
                     <div id="content-six" class="card card-content">
            <div class="card-img">
              <img src="https://prime.edu.np/wp-content/uploads/2023/08/Build-Your-Network-scaled.jpg" alt="#">
            </div>
            <div class="card-body">
              <h4>Build your Network</h4>
              <p>Join hands with creative minds</p>
              <a href="" class="btn btn-sm btn-light">View Detail</a>
            </div>
          </div>
                     <div id="content-seven" class="card card-content">
            <div class="card-img">
              <img src="https://prime.edu.np/wp-content/uploads/2023/08/Progressive-Infrastructure-scaled.jpg" alt="#">
            </div>
            <div class="card-body">
              <h4>Progressive Infrastructure</h4>
              <p>Create your foundation with our Progressive Infrastructures</p>
              <a href="https://prime.edu.np/infrastructure/" class="btn btn-sm btn-light">View Detail</a>
            </div>
          </div>
                   </div>
      </div>
    </div>
  </div>
</div>

<!-- Start Testimonials -->
<div class="testimonial-section block">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="section-head">
          <h2 class="section-title">Student's Experience</h2>
        </div>
      </div>
    </div>
    <div class="row justify-content-center srow">
      <div class="col-md-12 col-xl-10">
        <!-- Slider main container -->
        <div class="swiper testimonial-slider">
          <!-- Additional required wrapper -->
          <div class="swiper-wrapper">
            <!-- Slides -->
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3>Nirjala Shakya</h3>
                <p>BCA</p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                Prime College has been more than just an academic journey for me—it’s been a platform for growth and opportunity. Through my involvement in student clubs, I’ve enhanced my skills, expanded my network, and gained invaluable hands-on experience as an IT student. These experiences have been truly rewarding, enriching my portfolio and shaping my professional journey. 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2025/01/Screenshot-2025-01-13-142734.png" alt="#">
              </div>
            </div>
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3>Srijal Kapri</h3>
                <p>BSc. CSIT</p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                Prime College has been an incredible place for my academic growth. The faculty members, especially the IT Coordinator, are exceptionally supportive, knowledgeable, and dedicated to student performance. Their expertise and friendly approach make learning effective and engaging. The college environment is really good for learning as it believes in innovation and exploration. Additionally, the various student clubs that organize different programs make the college experience more entertaining and informative.


I truly appreciate how friendly, experienced, and qualified all the teachers in their field. Their guidance has not only uplifted my academics but also inspired me to develop personally. Choosing a prime college has been one of the best decisions and I am proud to be part of such a great institution. 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2025/01/0-02-03-b57e6073314c1aeabdab2212126e28fbc27055ba8e23b39a3401a52b6f75851b_935e8ec5a8965e16.jpg" alt="#">
              </div>
            </div>
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3>Subha Thapa</h3>
                <p>BBM </p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                Prime College has played a key role in shaping my educational and personal growth. The perfect combination of interactive faculty members, a positive learning environment, and enriching extracurricular activities has enhanced my creativity, knowledge, and overall perspective on life. Being a part of the Prime Entrepreneurial Management Club (EMC) has provided invaluable insights into entrepreneurship and strengthened my foundation for the future. My time at Prime has been eventful and productive defining my career path and transforming my approach to challenges and opportunities. I am truly grateful for the experiences and guidance I’ve received and look forward to continuing to contribute to this vibrant community, even after graduation. 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2023/08/subha.jpg" alt="#">
              </div>
            </div>
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3>Yunika Shakya</h3>
                <p>BSc. CSIT </p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                Prime College provided me with a path to learn and experience new things. It has facilitated my growth and development. Participating in college clubs and activities in a friendly environment and having supportive teachers and coordinators were plus points for me. Also, getting an opportunity to be an intern as a Creative Designer at MLRC enhanced my personal and professional growth. It allowed me to apply and grow my knowledge/ skills in real-world projects. Prime College has had a positive impact in my life. I highly recommend it to anyone looking for a college that challenges and supports them in achieving their goals.
 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2023/08/Yunika-Shakya-scaled.jpg" alt="#">
              </div>
            </div>
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3>Mamata Adhikari</h3>
                <p>BBM </p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                Prime College provides a platform for students to explore and work on their endeavours. The faculty members are knowledgeable experts and passionate mentors who go above and beyond to ensure success. Furthermore, seminars and clubs provide valuable knowledge and experience.
 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2023/08/Mamata-Adhikari-scaled.jpg" alt="#">
              </div>
            </div>
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3> Yashu Sthapit</h3>
                <p>BIM </p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                Prime College has exceeded my expectations in every aspect. The knowledgeable faculty and supportive environment have truly shaped my academic journey and prepared me for future success.
 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2023/08/Yashu-Sthapit-scaled.jpg" alt="#">
              </div>
            </div>
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3>Anjali Khanal</h3>
                <p>MBS </p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                Being a student of Prime College has actually changed me for the better. The challenging education, helpful environment, and enthusiastic lecturers have actually equipped me for my future job. Numerous training and workshops provided by the college have also helped me forge lifetime connections, gain experiences and develop my Inter/Intra personal skills. I am very much proud to be a student of this institution. 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2023/08/Anjali-Khanal-scaled.jpg" alt="#">
              </div>
            </div>
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3>Bishan Poudel</h3>
                <p>BCA </p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                I would like to express my heartfelt gratitude to Prime College for providing me with such a fantastic learning experience and job opportunities. My college was able to hone my skills and prepare me as a better member of the community. The college has an excellent placement cell, tied up with several top-notch companies. I have been fortunate enough to be offered a job by one of these companies. I would highly recommend this institution to anyone who is looking for quality education and a great gateway to start their corporate life. 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2023/09/image-43.png" alt="#">
              </div>
            </div>
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3>Sudikshya Sharma</h3>
                <p>BBA </p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                It is my immense fortune to be a part of Prime College. The entire faculty and department leaves no stone unturned to shape one’s future. Huge respect, love, and devotion for the entire faculty members and department. It is their effort that encourages me to count myself into a better profession. 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2023/08/Sudikshya-Sharma-scaled.jpg" alt="#">
              </div>
            </div>
                         <div class="swiper-slide testimonial-slider-item">
              <div class="student-info">
                <h3>Shreeya Shrestha</h3>
                <p>BBS </p>
                <div class="content">
                    <div class="quote-icon">
                        <img src="https://prime.edu.np/wp-content/themes/prime-college/assets/img/quote.png" alt="#">
                    </div>
                Studying at Prime College for these past few months has been an absolute blast as I am learning new things every day, and I feel like I am also growing as a person. Studying at Prime College has been by far one of the best decisions of my life and I have yet to explore the college fully and participate in future club activities, which I am looking forward to. 
                </div>
              </div>
              <div class="student-img">
                <img src="https://prime.edu.np/wp-content/uploads/2023/08/Shreeya-Shrestha-scaled.jpg" alt="#">
              </div>
            </div>
              
            
          </div>

          <!-- If we need navigation buttons -->
          <div class="swiper-button-prev"></div>
          <div class="swiper-button-next"></div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- End Testimonials -->



<!-- Start News And Event -->
<div class="news-event block pb-0">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="section-head">
          <h2 class="section-title">
            News and Events
          </h2>
          <div class="d-sm-flex justify-content-between">
            <p>Latest Events</p>
            <a href="https://prime.edu.np/events/" class="link">View All</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="news-event-area">
    <!-- Slider main container -->
    <div class="swiper news-event-slider">
      <!-- Additional required wrapper -->
      <div class="swiper-wrapper">
        <!-- Slides -->
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/12/Webinar_KPMG.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/Webinar_KPMG.png 1080w, https://prime.edu.np/wp-content/uploads/2024/12/Webinar_KPMG-300x300.png 300w, https://prime.edu.np/wp-content/uploads/2024/12/Webinar_KPMG-1024x1024.png 1024w, https://prime.edu.np/wp-content/uploads/2024/12/Webinar_KPMG-150x150.png 150w, https://prime.edu.np/wp-content/uploads/2024/12/Webinar_KPMG-768x768.png 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 4, 2024</div>
              <h4><a href="https://prime.edu.np/event/webinar-the-financial-anatomy-of-ipl-lessons-in-accounting/">Webinar &#8211; The Financial Anatomy of IPL: Lessons in Accounting</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1440" height="1440" src="https://prime.edu.np/wp-content/uploads/2024/12/470795809_543619352001990_3125569174070596708_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/470795809_543619352001990_3125569174070596708_n.jpg 1440w, https://prime.edu.np/wp-content/uploads/2024/12/470795809_543619352001990_3125569174070596708_n-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/12/470795809_543619352001990_3125569174070596708_n-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/12/470795809_543619352001990_3125569174070596708_n-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2024/12/470795809_543619352001990_3125569174070596708_n-768x768.jpg 768w" sizes="(max-width: 1440px) 100vw, 1440px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 18, 2024</div>
              <h4><a href="https://prime.edu.np/event/ink-and-imagination-vol-2-prime-flair-club/">Ink and Imagination Vol-2 | Prime Flair Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/12/468839188_9777254668959531_4122224525569538738_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/468839188_9777254668959531_4122224525569538738_n.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/12/468839188_9777254668959531_4122224525569538738_n-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/12/468839188_9777254668959531_4122224525569538738_n-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/12/468839188_9777254668959531_4122224525569538738_n-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2024/12/468839188_9777254668959531_4122224525569538738_n-768x768.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 3, 2024</div>
              <h4><a href="https://prime.edu.np/event/digital-marketing-workshop/">Digital Marketing Workshop</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/12/472036317_9928127880538875_8424459098420205738_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/472036317_9928127880538875_8424459098420205738_n.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/12/472036317_9928127880538875_8424459098420205738_n-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/12/472036317_9928127880538875_8424459098420205738_n-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/12/472036317_9928127880538875_8424459098420205738_n-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2024/12/472036317_9928127880538875_8424459098420205738_n-768x768.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 31, 2024</div>
              <h4><a href="https://prime.edu.np/event/jamacho-hike-mlrc/">Jamacho Hike | MLRC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2048" height="2048" src="https://prime.edu.np/wp-content/uploads/2025/01/473254283_997418485753934_6911098037935191120_n-1.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2025/01/473254283_997418485753934_6911098037935191120_n-1.jpg 2048w, https://prime.edu.np/wp-content/uploads/2025/01/473254283_997418485753934_6911098037935191120_n-1-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2025/01/473254283_997418485753934_6911098037935191120_n-1-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2025/01/473254283_997418485753934_6911098037935191120_n-1-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2025/01/473254283_997418485753934_6911098037935191120_n-1-768x768.jpg 768w, https://prime.edu.np/wp-content/uploads/2025/01/473254283_997418485753934_6911098037935191120_n-1-1536x1536.jpg 1536w" sizes="(max-width: 2048px) 100vw, 2048px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 9, 2025</div>
              <h4><a href="https://prime.edu.np/event/%f0%9d%90%93%f0%9d%90%a1%f0%9d%90%9e-%f0%9d%90%86%f0%9d%90%88%f0%9d%90%86-%f0%9d%90%84%f0%9d%90%9c%f0%9d%90%a8%f0%9d%90%a7%f0%9d%90%a8%f0%9d%90%a6%f0%9d%90%b2-%f0%9d%90%82%f0%9d%90%9a%f0%9d%90%a7/">The GIG Economy: Can learning and earning coexist in colleges of Nepal? | Panel Discussion</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2025/01/473688466_18259991296260140_3630701444883683255_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2025/01/473688466_18259991296260140_3630701444883683255_n.jpg 1080w, https://prime.edu.np/wp-content/uploads/2025/01/473688466_18259991296260140_3630701444883683255_n-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2025/01/473688466_18259991296260140_3630701444883683255_n-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2025/01/473688466_18259991296260140_3630701444883683255_n-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2025/01/473688466_18259991296260140_3630701444883683255_n-768x768.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 16, 2025</div>
              <h4><a href="https://prime.edu.np/event/idea-to-impact-turning-visions-into-reality-prime-emc/">Idea to Impact: Turning Visions into Reality | Prime EMC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1350" height="1687" src="https://prime.edu.np/wp-content/uploads/2024/12/470014409_18293707333235746_3753962910426197010_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/470014409_18293707333235746_3753962910426197010_n.jpg 1350w, https://prime.edu.np/wp-content/uploads/2024/12/470014409_18293707333235746_3753962910426197010_n-240x300.jpg 240w, https://prime.edu.np/wp-content/uploads/2024/12/470014409_18293707333235746_3753962910426197010_n-819x1024.jpg 819w, https://prime.edu.np/wp-content/uploads/2024/12/470014409_18293707333235746_3753962910426197010_n-768x960.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/12/470014409_18293707333235746_3753962910426197010_n-1229x1536.jpg 1229w" sizes="(max-width: 1350px) 100vw, 1350px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 16, 2024</div>
              <h4><a href="https://prime.edu.np/event/shrijay-memorial-ict-cup-2025-prime-it-club/">SHRIJAY MEMORIAL ICT CUP 2025 | Prime IT Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1350" src="https://prime.edu.np/wp-content/uploads/2024/11/468701085_1100631758519761_186031010732411699_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/11/468701085_1100631758519761_186031010732411699_n.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/11/468701085_1100631758519761_186031010732411699_n-240x300.jpg 240w, https://prime.edu.np/wp-content/uploads/2024/11/468701085_1100631758519761_186031010732411699_n-819x1024.jpg 819w, https://prime.edu.np/wp-content/uploads/2024/11/468701085_1100631758519761_186031010732411699_n-768x960.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Nov 24, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-sports-gala-2081-prime-sports-club/">21st Prime Sports Gala 2081 | Prime Sports Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="609" height="714" src="https://prime.edu.np/wp-content/uploads/2024/11/Screen-Shot-2024-11-21-at-10.30.23-AM.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/11/Screen-Shot-2024-11-21-at-10.30.23-AM.png 609w, https://prime.edu.np/wp-content/uploads/2024/11/Screen-Shot-2024-11-21-at-10.30.23-AM-256x300.png 256w" sizes="(max-width: 609px) 100vw, 609px" />            </div>
            <div class="card-body">
              <div class="post-date">Nov 21, 2024</div>
              <h4><a href="https://prime.edu.np/event/starting-in-it-field-prime-it-club/">Starting in IT Field | Prime IT Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1350" src="https://prime.edu.np/wp-content/uploads/2024/11/Social-Media-Post-Orientation-2081.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/11/Social-Media-Post-Orientation-2081.png 1080w, https://prime.edu.np/wp-content/uploads/2024/11/Social-Media-Post-Orientation-2081-240x300.png 240w, https://prime.edu.np/wp-content/uploads/2024/11/Social-Media-Post-Orientation-2081-819x1024.png 819w, https://prime.edu.np/wp-content/uploads/2024/11/Social-Media-Post-Orientation-2081-768x960.png 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Nov 13, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-orientation-program-2081/">Prime Orientation Program 2081</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1349" src="https://prime.edu.np/wp-content/uploads/2024/11/465375938_1081515457098058_1024475649769892061_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/11/465375938_1081515457098058_1024475649769892061_n.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/11/465375938_1081515457098058_1024475649769892061_n-240x300.jpg 240w, https://prime.edu.np/wp-content/uploads/2024/11/465375938_1081515457098058_1024475649769892061_n-820x1024.jpg 820w, https://prime.edu.np/wp-content/uploads/2024/11/465375938_1081515457098058_1024475649769892061_n-768x959.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Nov 6, 2024</div>
              <h4><a href="https://prime.edu.np/event/inter-club-futsal-tournament/">Inter-Club Futsal Tournament</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1350" height="1687" src="https://prime.edu.np/wp-content/uploads/2024/10/464620039_529814369842816_2069891356149677695_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/10/464620039_529814369842816_2069891356149677695_n.jpg 1350w, https://prime.edu.np/wp-content/uploads/2024/10/464620039_529814369842816_2069891356149677695_n-240x300.jpg 240w, https://prime.edu.np/wp-content/uploads/2024/10/464620039_529814369842816_2069891356149677695_n-819x1024.jpg 819w, https://prime.edu.np/wp-content/uploads/2024/10/464620039_529814369842816_2069891356149677695_n-768x960.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/10/464620039_529814369842816_2069891356149677695_n-1229x1536.jpg 1229w" sizes="(max-width: 1350px) 100vw, 1350px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 29, 2024</div>
              <h4><a href="https://prime.edu.np/event/deusi-bhailo-2081/">Deusi Bhailo 2081</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/10/462483042_516401944517392_1117041747096679010_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/10/462483042_516401944517392_1117041747096679010_n.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/10/462483042_516401944517392_1117041747096679010_n-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/10/462483042_516401944517392_1117041747096679010_n-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/10/462483042_516401944517392_1117041747096679010_n-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2024/10/462483042_516401944517392_1117041747096679010_n-768x768.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 17, 2024</div>
              <h4><a href="https://prime.edu.np/event/kpmg-us-cpa-united-states-certified-public-accountant-webinar/">KPMG US CPA (United States Certified Public Accountant) &#8211; Webinar</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1441" src="https://prime.edu.np/wp-content/uploads/2024/10/PCDC-23-of-45-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/10/PCDC-23-of-45-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2024/10/PCDC-23-of-45-300x169.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/10/PCDC-23-of-45-1024x577.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/10/PCDC-23-of-45-768x432.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/10/PCDC-23-of-45-1536x865.jpg 1536w, https://prime.edu.np/wp-content/uploads/2024/10/PCDC-23-of-45-2048x1153.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 4, 2024</div>
              <h4><a href="https://prime.edu.np/event/changa-chait-program-mlrc/">Prime College Celebrates Dashain with Joy and Tradition | MLRC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1448" height="2048" src="https://prime.edu.np/wp-content/uploads/2024/09/460124658_1058889395628617_5927326607711363784_n.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/09/460124658_1058889395628617_5927326607711363784_n.png 1448w, https://prime.edu.np/wp-content/uploads/2024/09/460124658_1058889395628617_5927326607711363784_n-212x300.png 212w, https://prime.edu.np/wp-content/uploads/2024/09/460124658_1058889395628617_5927326607711363784_n-724x1024.png 724w, https://prime.edu.np/wp-content/uploads/2024/09/460124658_1058889395628617_5927326607711363784_n-768x1086.png 768w, https://prime.edu.np/wp-content/uploads/2024/09/460124658_1058889395628617_5927326607711363784_n-1086x1536.png 1086w" sizes="(max-width: 1448px) 100vw, 1448px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 8, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-club-executive-night-2081-mlrc/">Prime Club Executive Night 2081: A Celebration of Connection and Collaboration | MLRC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/09/KMPG.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/09/KMPG.png 1080w, https://prime.edu.np/wp-content/uploads/2024/09/KMPG-300x300.png 300w, https://prime.edu.np/wp-content/uploads/2024/09/KMPG-1024x1024.png 1024w, https://prime.edu.np/wp-content/uploads/2024/09/KMPG-150x150.png 150w, https://prime.edu.np/wp-content/uploads/2024/09/KMPG-768x768.png 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Sep 24, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-college-collaborates-with-kpmg-in-india-to-introduce-one-of-the-first-ever-us-cpa-test-preparation-programs-in-nepal/">Prime College Collaborates with KPMG in India to Introduce one of the first ever US CPA Test Preparation Programs in Nepal</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/07/Reformation.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/07/Reformation.png 1080w, https://prime.edu.np/wp-content/uploads/2024/07/Reformation-300x300.png 300w, https://prime.edu.np/wp-content/uploads/2024/07/Reformation-1024x1024.png 1024w, https://prime.edu.np/wp-content/uploads/2024/07/Reformation-150x150.png 150w, https://prime.edu.np/wp-content/uploads/2024/07/Reformation-768x768.png 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Sep 11, 2024</div>
              <h4><a href="https://prime.edu.np/event/student-club-reformation-2081/">Prime College Hosts Student Club Reformation Program: A Celebration of Leadership and Community</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/09/459151022_954038256766726_6924652427114122476_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/09/459151022_954038256766726_6924652427114122476_n.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/09/459151022_954038256766726_6924652427114122476_n-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/09/459151022_954038256766726_6924652427114122476_n-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/09/459151022_954038256766726_6924652427114122476_n-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2024/09/459151022_954038256766726_6924652427114122476_n-768x768.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Sep 11, 2024</div>
              <h4><a href="https://prime.edu.np/event/indra-jatra-prime-cultural-club/">INDRA JATRA | Prime Cultural Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-756-of-909-1-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-756-of-909-1-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-756-of-909-1-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-756-of-909-1-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-756-of-909-1-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-756-of-909-1-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2024/07/PCPGC2081-756-of-909-1-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Aug 13, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-graduation-ceremony-2081/">Prime Graduation Ceremony 2081: A Celebration of Achievement and Aspiration</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="828" height="1169" src="https://prime.edu.np/wp-content/uploads/2024/07/Eduroam.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="Prime College Eduroam connectivity guide. Header: &#039;Connect with Eduroam: Secure, Worldwide Access.&#039; Eduroam offers secure, worldwide roaming access for the research and education community. Steps to connect: 1. Open WiFi and click on Eduroam. 2. Select &#039;Don&#039;t validate for CA.&#039; 3. Enter your Prime email ID and password to connect. Benefits: Seamless connectivity, secure, convenient. For help, contact the I.T. Department. Key notes: Use the given Prime email ID on one device at a time, and you cannot change the provided password. Logos of Prime College, Prime Educational Inc., Eduroam, and NREN are at the bottom." decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/07/Eduroam.png 828w, https://prime.edu.np/wp-content/uploads/2024/07/Eduroam-212x300.png 212w, https://prime.edu.np/wp-content/uploads/2024/07/Eduroam-725x1024.png 725w, https://prime.edu.np/wp-content/uploads/2024/07/Eduroam-768x1084.png 768w" sizes="(max-width: 828px) 100vw, 828px" />            </div>
            <div class="card-body">
              <div class="post-date">Aug 1, 2024</div>
              <h4><a href="https://prime.edu.np/event/connect-with-eduroam-secure-worldwide-access/">Connect with Eduroam: Secure, Worldwide Access</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/07/AIT.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="Announcement from Prime College about their partnership with the Asian Institute of Technology (AIT). The image includes logos of both institutions and a handshake graphic. The text mentions that students can now complete joint bachelor&#039;s and master&#039;s programs through this collaboration. Social media icons are displayed at the top right." decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/07/AIT.png 1080w, https://prime.edu.np/wp-content/uploads/2024/07/AIT-300x300.png 300w, https://prime.edu.np/wp-content/uploads/2024/07/AIT-1024x1024.png 1024w, https://prime.edu.np/wp-content/uploads/2024/07/AIT-150x150.png 150w, https://prime.edu.np/wp-content/uploads/2024/07/AIT-768x768.png 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Jul 25, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-college-announces-partnership-with-asian-institute-of-technology-ait/">Prime College Announces Partnership with Asian Institute of Technology (AIT)</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1280" height="1600" src="https://prime.edu.np/wp-content/uploads/2024/07/456241782_17935883315873012_952158015473837324_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/07/456241782_17935883315873012_952158015473837324_n.jpg 1280w, https://prime.edu.np/wp-content/uploads/2024/07/456241782_17935883315873012_952158015473837324_n-240x300.jpg 240w, https://prime.edu.np/wp-content/uploads/2024/07/456241782_17935883315873012_952158015473837324_n-819x1024.jpg 819w, https://prime.edu.np/wp-content/uploads/2024/07/456241782_17935883315873012_952158015473837324_n-768x960.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/07/456241782_17935883315873012_952158015473837324_n-1229x1536.jpg 1229w" sizes="(max-width: 1280px) 100vw, 1280px" />            </div>
            <div class="card-body">
              <div class="post-date">Jul 15, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-college-carnival/">PRIME COLLEGE CARNIVAL 2024 | Prime Flair Club | Prime EMC | Prime E-sports Hub</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2024/06/IMG_3172-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/06/IMG_3172-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2024/06/IMG_3172-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/06/IMG_3172-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/06/IMG_3172-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/06/IMG_3172-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2024/06/IMG_3172-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Jun 21, 2024</div>
              <h4><a href="https://prime.edu.np/event/she-leads-inspiring-journey-of-wonder-women-prime-emc/">Prime College Hosts Empowering Event &#8220;She Leads: Inspiring Journey of Wonder Women&#8221; | Prime EMC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1082" height="907" src="https://prime.edu.np/wp-content/uploads/2024/06/447510715_980431480539790_1140430537823667991_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/06/447510715_980431480539790_1140430537823667991_n.jpg 1082w, https://prime.edu.np/wp-content/uploads/2024/06/447510715_980431480539790_1140430537823667991_n-300x251.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/06/447510715_980431480539790_1140430537823667991_n-1024x858.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/06/447510715_980431480539790_1140430537823667991_n-768x644.jpg 768w" sizes="(max-width: 1082px) 100vw, 1082px" />            </div>
            <div class="card-body">
              <div class="post-date">May 19, 2024</div>
              <h4><a href="https://prime.edu.np/event/game-on-square-prime-sports-club/">Game on Square | Prime Sports Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2048" height="1365" src="https://prime.edu.np/wp-content/uploads/2024/05/443733528_419922677498653_2839625456478159986_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/05/443733528_419922677498653_2839625456478159986_n.jpg 2048w, https://prime.edu.np/wp-content/uploads/2024/05/443733528_419922677498653_2839625456478159986_n-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/05/443733528_419922677498653_2839625456478159986_n-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/05/443733528_419922677498653_2839625456478159986_n-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/05/443733528_419922677498653_2839625456478159986_n-1536x1024.jpg 1536w" sizes="(max-width: 2048px) 100vw, 2048px" />            </div>
            <div class="card-body">
              <div class="post-date">May 13, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-futsal-league-season-2080-81-celebrating-champions-and-sportsmanship/">Prime Futsal League Season 2080/81: Celebrating Champions and Sportsmanship</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2024/05/IMG_0004-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/05/IMG_0004-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2024/05/IMG_0004-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/05/IMG_0004-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/05/IMG_0004-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/05/IMG_0004-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2024/05/IMG_0004-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">May 2, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-bizfest-2024/">Prime Bizfest 2024 | Prime EMCPrime Bizfest 2024: Igniting Entrepreneurial Excellence | Prime EMC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1350" src="https://prime.edu.np/wp-content/uploads/2024/04/440941873_122154184814039650_6995734837840838009_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/04/440941873_122154184814039650_6995734837840838009_n.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/04/440941873_122154184814039650_6995734837840838009_n-240x300.jpg 240w, https://prime.edu.np/wp-content/uploads/2024/04/440941873_122154184814039650_6995734837840838009_n-819x1024.jpg 819w, https://prime.edu.np/wp-content/uploads/2024/04/440941873_122154184814039650_6995734837840838009_n-768x960.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Apr 30, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-fifa-fiesta/">Prime FIFA Fiesta | Prime Esports Hub</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/04/Embracing-change-for-educational-advancement-120778.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/04/Embracing-change-for-educational-advancement-120778.png 1080w, https://prime.edu.np/wp-content/uploads/2024/04/Embracing-change-for-educational-advancement-120778-300x300.png 300w, https://prime.edu.np/wp-content/uploads/2024/04/Embracing-change-for-educational-advancement-120778-1024x1024.png 1024w, https://prime.edu.np/wp-content/uploads/2024/04/Embracing-change-for-educational-advancement-120778-150x150.png 150w, https://prime.edu.np/wp-content/uploads/2024/04/Embracing-change-for-educational-advancement-120778-768x768.png 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Apr 18, 2024</div>
              <h4><a href="https://prime.edu.np/event/embracing-change-for-educational-advancement/">शिक्षामा नवीनता &#8211; “Embracing Change for Educational Advancement&#8221;</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1355" height="1923" src="https://prime.edu.np/wp-content/uploads/2024/03/421221828_8041878555830493_532687142708023032_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/03/421221828_8041878555830493_532687142708023032_n.jpg 1355w, https://prime.edu.np/wp-content/uploads/2024/03/421221828_8041878555830493_532687142708023032_n-211x300.jpg 211w, https://prime.edu.np/wp-content/uploads/2024/03/421221828_8041878555830493_532687142708023032_n-722x1024.jpg 722w, https://prime.edu.np/wp-content/uploads/2024/03/421221828_8041878555830493_532687142708023032_n-768x1090.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/03/421221828_8041878555830493_532687142708023032_n-1082x1536.jpg 1082w" sizes="(max-width: 1355px) 100vw, 1355px" />            </div>
            <div class="card-body">
              <div class="post-date">Mar 31, 2024</div>
              <h4><a href="https://prime.edu.np/event/online-character-certificate-eligibility-and-application-procedure/">Online College Leaving Certificate &#8211; Eligibility and Application Procedure</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2048" height="1365" src="https://prime.edu.np/wp-content/uploads/2024/03/420173062_387030260787895_1599942019332965253_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/03/420173062_387030260787895_1599942019332965253_n.jpg 2048w, https://prime.edu.np/wp-content/uploads/2024/03/420173062_387030260787895_1599942019332965253_n-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/03/420173062_387030260787895_1599942019332965253_n-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/03/420173062_387030260787895_1599942019332965253_n-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/03/420173062_387030260787895_1599942019332965253_n-1536x1024.jpg 1536w" sizes="(max-width: 2048px) 100vw, 2048px" />            </div>
            <div class="card-body">
              <div class="post-date">Mar 20, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-colleges-welcome-farewell-program-2080/">Prime College&#8217;s Welcome Farewell Program 2080</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1600" height="1200" src="https://prime.edu.np/wp-content/uploads/2024/02/image-7.jpeg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/02/image-7.jpeg 1600w, https://prime.edu.np/wp-content/uploads/2024/02/image-7-300x225.jpeg 300w, https://prime.edu.np/wp-content/uploads/2024/02/image-7-1024x768.jpeg 1024w, https://prime.edu.np/wp-content/uploads/2024/02/image-7-768x576.jpeg 768w, https://prime.edu.np/wp-content/uploads/2024/02/image-7-1536x1152.jpeg 1536w" sizes="(max-width: 1600px) 100vw, 1600px" />            </div>
            <div class="card-body">
              <div class="post-date">Feb 21, 2024</div>
              <h4><a href="https://prime.edu.np/event/welcome-to-kathmandu-valley-new-students/">Welcome to Kathmandu Valley, New Students </a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2048" height="1365" src="https://prime.edu.np/wp-content/uploads/2024/01/418973280_775336061290332_5582459766125105047_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/01/418973280_775336061290332_5582459766125105047_n.jpg 2048w, https://prime.edu.np/wp-content/uploads/2024/01/418973280_775336061290332_5582459766125105047_n-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/01/418973280_775336061290332_5582459766125105047_n-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/01/418973280_775336061290332_5582459766125105047_n-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/01/418973280_775336061290332_5582459766125105047_n-1536x1024.jpg 1536w" sizes="(max-width: 2048px) 100vw, 2048px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 31, 2024</div>
              <h4><a href="https://prime.edu.np/event/prime-college-unveils-success-of-ict-meetup-v7-0-organized-by-prime-it-club/">Prime College Unveils Success of ICT Meetup V7.0 Organized by Prime IT Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta.jpg 1080w, https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta-768x768.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 24, 2024</div>
              <h4><a href="https://prime.edu.np/event/unveiling-the-exciting-second-edition-of-vrittanta/">Unveiling the Exciting Second Edition of &#8216;Vrittanta:&#8217;</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="810" src="https://prime.edu.np/wp-content/uploads/2024/01/image-1.jpeg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/01/image-1.jpeg 1080w, https://prime.edu.np/wp-content/uploads/2024/01/image-1-300x225.jpeg 300w, https://prime.edu.np/wp-content/uploads/2024/01/image-1-1024x768.jpeg 1024w, https://prime.edu.np/wp-content/uploads/2024/01/image-1-768x576.jpeg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 16, 2024</div>
              <h4><a href="https://prime.edu.np/event/successful-blood-donation-campaign-at-prime-college/">Successful Blood Donation Campaign at Prime College </a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1349" height="1687" src="https://prime.edu.np/wp-content/uploads/2023/12/408990190_18247487419235746_4327342561563846114_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/12/408990190_18247487419235746_4327342561563846114_n.jpg 1349w, https://prime.edu.np/wp-content/uploads/2023/12/408990190_18247487419235746_4327342561563846114_n-240x300.jpg 240w, https://prime.edu.np/wp-content/uploads/2023/12/408990190_18247487419235746_4327342561563846114_n-819x1024.jpg 819w, https://prime.edu.np/wp-content/uploads/2023/12/408990190_18247487419235746_4327342561563846114_n-768x960.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/12/408990190_18247487419235746_4327342561563846114_n-1228x1536.jpg 1228w" sizes="(max-width: 1349px) 100vw, 1349px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 21, 2023</div>
              <h4><a href="https://prime.edu.np/event/prime-it-club-leading-the-way-in-tech-with-ict-meetup-v7-0-prime-college/">Prime IT Club: Leading the Way in Tech with ICT Meetup V7.0 | Prime College</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2023/12/410974671_332859799538275_7898516560910865349_n-1.jpeg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/12/410974671_332859799538275_7898516560910865349_n-1.jpeg 1080w, https://prime.edu.np/wp-content/uploads/2023/12/410974671_332859799538275_7898516560910865349_n-1-300x300.jpeg 300w, https://prime.edu.np/wp-content/uploads/2023/12/410974671_332859799538275_7898516560910865349_n-1-1024x1024.jpeg 1024w, https://prime.edu.np/wp-content/uploads/2023/12/410974671_332859799538275_7898516560910865349_n-1-150x150.jpeg 150w, https://prime.edu.np/wp-content/uploads/2023/12/410974671_332859799538275_7898516560910865349_n-1-768x768.jpeg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 19, 2023</div>
              <h4><a href="https://prime.edu.np/event/introducing-the-executive-board-of-prime-college-alumni-association/">Introducing the Executive Board of Prime College Alumni Association</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/12/PCOP80-350-of-488-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/12/PCOP80-350-of-488-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/12/PCOP80-350-of-488-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/12/PCOP80-350-of-488-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/12/PCOP80-350-of-488-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/12/PCOP80-350-of-488-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/12/PCOP80-350-of-488-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 18, 2023</div>
              <h4><a href="https://prime.edu.np/event/prime-orientation-program-2080-prime-college/">Prime Orientation Program 2080 | Prime College</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1441" src="https://prime.edu.np/wp-content/uploads/2023/12/20231202_152600-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/12/20231202_152600-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/12/20231202_152600-300x169.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/12/20231202_152600-1024x577.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/12/20231202_152600-768x432.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/12/20231202_152600-1536x865.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/12/20231202_152600-2048x1153.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 8, 2023</div>
              <h4><a href="https://prime.edu.np/event/prime-colleges-first-ever-inter-student-club-futsal/">Prime College&#8217;s First-Ever Inter-Student Club Futsal </a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/12/PCPAD-168-of-286-1-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/12/PCPAD-168-of-286-1-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/12/PCPAD-168-of-286-1-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/12/PCPAD-168-of-286-1-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/12/PCPAD-168-of-286-1-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/12/PCPAD-168-of-286-1-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/12/PCPAD-168-of-286-1-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 3, 2023</div>
              <h4><a href="https://prime.edu.np/event/prime-alumni-dinner-prime-college/">Prime Alumni Dinner 2080 | Prime College</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta.jpg 1080w, https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2023/10/Vrittanta-768x768.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 20, 2023</div>
              <h4><a href="https://prime.edu.np/event/vrittanta-unveiling-our-quarterly-newsletter/">Vrittanta: Unveiling Our Quarterly Newsletter</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="999" height="749" src="https://prime.edu.np/wp-content/uploads/2023/10/image-38.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/10/image-38.png 999w, https://prime.edu.np/wp-content/uploads/2023/10/image-38-300x225.png 300w, https://prime.edu.np/wp-content/uploads/2023/10/image-38-768x576.png 768w" sizes="(max-width: 999px) 100vw, 999px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 20, 2023</div>
              <h4><a href="https://prime.edu.np/event/industrial-visit-to-barahsinghe-yak-brewery-bim-2019/">Industrial Visit to Barahsinghe – Yak Brewery | BIM 2019</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1440" height="960" src="https://prime.edu.np/wp-content/uploads/2023/10/391616941_18209565001261107_4185982729490321527_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/10/391616941_18209565001261107_4185982729490321527_n.jpg 1440w, https://prime.edu.np/wp-content/uploads/2023/10/391616941_18209565001261107_4185982729490321527_n-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/10/391616941_18209565001261107_4185982729490321527_n-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/10/391616941_18209565001261107_4185982729490321527_n-768x512.jpg 768w" sizes="(max-width: 1440px) 100vw, 1440px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 19, 2023</div>
              <h4><a href="https://prime.edu.np/event/dashain-celebration-at-prime-college-prime-cultural-club/">Dashain Celebration at Prime College | Prime Cultural Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/10/PCEN-196-of-439-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/10/PCEN-196-of-439-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/10/PCEN-196-of-439-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/10/PCEN-196-of-439-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/10/PCEN-196-of-439-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/10/PCEN-196-of-439-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/10/PCEN-196-of-439-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 9, 2023</div>
              <h4><a href="https://prime.edu.np/event/club-executive-night/">Prime Club Executive Night: Building Connections for the Future</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/07/PCR-293-of-372-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/PCR-293-of-372-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/07/PCR-293-of-372-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/07/PCR-293-of-372-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/PCR-293-of-372-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/07/PCR-293-of-372-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/07/PCR-293-of-372-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Sep 24, 2023</div>
              <h4><a href="https://prime.edu.np/event/club-reformation/">Student Club Reformation: Celebrating Leadership and Achievements</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2023/07/AYU_1907_pp-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/AYU_1907_pp-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/07/AYU_1907_pp-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/07/AYU_1907_pp-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/AYU_1907_pp-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/07/AYU_1907_pp-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/07/AYU_1907_pp-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Sep 13, 2023</div>
              <h4><a href="https://prime.edu.np/event/admission-open/">Admission Open for Bachelor Program at Prime College</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1440" height="960" src="https://prime.edu.np/wp-content/uploads/2023/07/375042453_615840130733730_5422038540697253480_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/375042453_615840130733730_5422038540697253480_n.jpg 1440w, https://prime.edu.np/wp-content/uploads/2023/07/375042453_615840130733730_5422038540697253480_n-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/07/375042453_615840130733730_5422038540697253480_n-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/375042453_615840130733730_5422038540697253480_n-768x512.jpg 768w" sizes="(max-width: 1440px) 100vw, 1440px" />            </div>
            <div class="card-body">
              <div class="post-date">Sep 2, 2023</div>
              <h4><a href="https://prime.edu.np/event/prime_bizfest/">Prime BizFest 2023 at Prime College | Prime EMC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1710" src="https://prime.edu.np/wp-content/uploads/2023/07/DSC01168-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/07/DSC01168-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2023/07/DSC01168-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/07/DSC01168-1024x684.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/07/DSC01168-768x513.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/07/DSC01168-1536x1026.jpg 1536w, https://prime.edu.np/wp-content/uploads/2023/07/DSC01168-2048x1368.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Aug 26, 2023</div>
              <h4><a href="https://prime.edu.np/event/sukul_session_vol_2/">Sukul Session Vol. 2 | Prime Flair Hub</a></h4>
            </div>
          </div>
        </div>
              </div>
    </div>
  </div>
</div>
<!-- End News And Event -->


<!-- Start News And Event -->
<div class="news-event block pb-0">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="section-head">
          <div class="d-sm-flex justify-content-between">
            <p>Upcoming Events</p>
            <a href="https://prime.edu.np/events/" class="link">View All</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="news-event-area">
    <!-- Slider main container -->
    <div class="swiper news-event-slider">
      <!-- Additional required wrapper -->
      <div class="swiper-wrapper">
        <!-- Slides -->
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1350" src="https://prime.edu.np/wp-content/uploads/2025/01/WF_SMP_Final.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2025/01/WF_SMP_Final.png 1080w, https://prime.edu.np/wp-content/uploads/2025/01/WF_SMP_Final-240x300.png 240w, https://prime.edu.np/wp-content/uploads/2025/01/WF_SMP_Final-819x1024.png 819w, https://prime.edu.np/wp-content/uploads/2025/01/WF_SMP_Final-768x960.png 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 5, 2025</div>
              <h4><a href="https://prime.edu.np/event/welcome-and-farewell-2081/">Welcome &amp; Farewell Program 2081</a></h4>
            </div>
          </div>
        </div>
                 <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/07/blue-promotion-schedule-instagram-post-design.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="Prime College Seminar Hall and Multipurpose Room Schedule. The image features the Prime College logo at the top, with the text &#039;Seminar Hall &amp; Multipurpose Room Schedule&#039; beneath it. Below the text is an illustration of a calendar with a few dates highlighted, signifying the schedule." decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/07/blue-promotion-schedule-instagram-post-design.png 1080w, https://prime.edu.np/wp-content/uploads/2024/07/blue-promotion-schedule-instagram-post-design-300x300.png 300w, https://prime.edu.np/wp-content/uploads/2024/07/blue-promotion-schedule-instagram-post-design-1024x1024.png 1024w, https://prime.edu.np/wp-content/uploads/2024/07/blue-promotion-schedule-instagram-post-design-150x150.png 150w, https://prime.edu.np/wp-content/uploads/2024/07/blue-promotion-schedule-instagram-post-design-768x768.png 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Jul 28, 2024</div>
              <h4><a href="https://prime.edu.np/event/upcoming-events-seminar-hall-multipurpose-room-schedule/">Upcoming Events: Seminar Hall &amp; Multipurpose Room Schedule</a></h4>
            </div>
          </div>
        </div>
               </div>
    </div>
  </div>
</div>
<!-- End News And Event -->

<!--Start Notice Section-->
<div class="notice-section block pb-0 d-none">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="section-head mb-5">
          <h2 class="section-title">Notices</h2>
        </div>
      </div>
    </div>
    <div class="row g-4 justify-content-around">
                <div class="col-sm-12 col-md-4 col-lg-4">
            <div class="notice-item equal-height">
                
                        <h4><a href="https://prime.edu.np/wp-content/uploads/2024/03/Dress-Code-Guidelines.jpg" class="fancybox" data-fancybox="images-preview">Dress Code Guidelines</a></h4>
                        <p class="mb-0">Mar 29, 2024</p>
                    
                        <a href="https://prime.edu.np/wp-content/uploads/2024/03/Dress-Code-Guidelines.jpg" class="view-link" data-fancybox="images-preview">View Detail</a>
                  
                
            </div>
        </div>
                <div class="col-sm-12 col-md-4 col-lg-4">
            <div class="notice-item equal-height">
                
                        <h4><a href="https://prime.edu.np/wp-content/uploads/2024/03/421221828_8041878555830493_532687142708023032_n.jpg" class="fancybox" data-fancybox="images-preview">Online College Leaving Certificate</a></h4>
                        <p class="mb-0">Mar 31, 2024</p>
                    
                        <a href="https://prime.edu.np/wp-content/uploads/2024/03/421221828_8041878555830493_532687142708023032_n.jpg" class="view-link" data-fancybox="images-preview">View Detail</a>
                  
                
            </div>
        </div>
                <div class="col-sm-12 col-md-4 col-lg-4">
            <div class="notice-item equal-height">
                
                        <h4><a href="https://prime.edu.np/wp-content/uploads/2024/04/Financial-Literacy-Session-scaled.jpg" class="fancybox" data-fancybox="images-preview">Notice to BBA/BIM/BBM Students &#8211; Financial Literacy Session</a></h4>
                        <p class="mb-0">Apr 1, 2024</p>
                    
                        <a href="https://prime.edu.np/wp-content/uploads/2024/04/Financial-Literacy-Session-scaled.jpg" class="view-link" data-fancybox="images-preview">View Detail</a>
                  
                
            </div>
        </div>
            </div>
              <div class="mt-4 text-center">
      <a href="https://prime.edu.np/notices" class="btn btn-primary">See All Notices</a>
  </div>
    </div>
    </div>
<!--End Notice Section-->

<!--Start Prime Blog-->
<div class="prime-blog-section block pb-0">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-head">
                    <h3 class="section-title">
                        <a href="https://prime.edu.np/prime-blog" class="text-primary">Prime Blogs</a>
                    </h3>
                </div>
            </div>
        </div>
    </div>
      <div class="news-event-area">
    <!-- Slider main container -->
    <div class="swiper news-event-slider">
      <!-- Additional required wrapper -->
      <div class="swiper-wrapper">
        <!-- Slides -->
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1600" height="1200" src="https://prime.edu.np/wp-content/uploads/2024/12/IMG-20240207-WA0024.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/IMG-20240207-WA0024.jpg 1600w, https://prime.edu.np/wp-content/uploads/2024/12/IMG-20240207-WA0024-300x225.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/12/IMG-20240207-WA0024-1024x768.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/12/IMG-20240207-WA0024-768x576.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/12/IMG-20240207-WA0024-1536x1152.jpg 1536w" sizes="(max-width: 1600px) 100vw, 1600px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 13, 2025</div>
              <h4><a href="https://prime.edu.np/prime_blog/reflections-of-leadership-my-journey-as-president-of-prime-sports-club-prabin-lama-bba-2076-batch/">Reflections of Leadership: My Journey as President of Prime Sports Club | Prabin Lama, BBA  2076 Batch</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1920" src="https://prime.edu.np/wp-content/uploads/2025/01/IMG20250104122923-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2025/01/IMG20250104122923-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2025/01/IMG20250104122923-300x225.jpg 300w, https://prime.edu.np/wp-content/uploads/2025/01/IMG20250104122923-1024x768.jpg 1024w, https://prime.edu.np/wp-content/uploads/2025/01/IMG20250104122923-768x576.jpg 768w, https://prime.edu.np/wp-content/uploads/2025/01/IMG20250104122923-1536x1152.jpg 1536w, https://prime.edu.np/wp-content/uploads/2025/01/IMG20250104122923-2048x1536.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 10, 2025</div>
              <h4><a href="https://prime.edu.np/prime_blog/exploring-connections-a-reflective-journey-to-jamacho-niraj-thapa-magar-mlrc-coordinator/">Exploring Connections: A Reflective Journey to Jamacho | Niraj Thapa Magar, MLRC Coordinator</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1440" height="960" src="https://prime.edu.np/wp-content/uploads/2025/01/472036882_17951888546873012_2150606352062312944_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2025/01/472036882_17951888546873012_2150606352062312944_n.jpg 1440w, https://prime.edu.np/wp-content/uploads/2025/01/472036882_17951888546873012_2150606352062312944_n-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2025/01/472036882_17951888546873012_2150606352062312944_n-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2025/01/472036882_17951888546873012_2150606352062312944_n-768x512.jpg 768w" sizes="(max-width: 1440px) 100vw, 1440px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 5, 2025</div>
              <h4><a href="https://prime.edu.np/prime_blog/ink-and-imagination-vol-2-prime-flair-club/">Ink and Imagination Vol. 2 | Prime Flair Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1624" src="https://prime.edu.np/wp-content/uploads/2024/12/Screenshot_20241227_134346_Instagram-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/Screenshot_20241227_134346_Instagram-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2024/12/Screenshot_20241227_134346_Instagram-300x190.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/12/Screenshot_20241227_134346_Instagram-1024x650.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/12/Screenshot_20241227_134346_Instagram-768x487.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/12/Screenshot_20241227_134346_Instagram-1536x975.jpg 1536w, https://prime.edu.np/wp-content/uploads/2024/12/Screenshot_20241227_134346_Instagram-2048x1300.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 1, 2025</div>
              <h4><a href="https://prime.edu.np/prime_blog/leading-with-heart-my-journey-as-president-of-prime-cultural-club-yuki-maharjan-bba-2076-batch/">Leading with Heart: My Journey as President of Prime Cultural Club | Yuki Maharjan, BBA 2076 Batch</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2016" height="1512" src="https://prime.edu.np/wp-content/uploads/2024/12/Received-Image-from-Rudeshman.jpeg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/Received-Image-from-Rudeshman.jpeg 2016w, https://prime.edu.np/wp-content/uploads/2024/12/Received-Image-from-Rudeshman-300x225.jpeg 300w, https://prime.edu.np/wp-content/uploads/2024/12/Received-Image-from-Rudeshman-1024x768.jpeg 1024w, https://prime.edu.np/wp-content/uploads/2024/12/Received-Image-from-Rudeshman-768x576.jpeg 768w, https://prime.edu.np/wp-content/uploads/2024/12/Received-Image-from-Rudeshman-1536x1152.jpeg 1536w" sizes="(max-width: 2016px) 100vw, 2016px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 22, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/rudesh-manandhar-leading-with-vision-my-journey-with-the-prime-flair-club-bsc-csit-2076-batch/">Rudesh Manandhar: Leading with Vision &#8211; My Journey with the Prime Flair Club | BSc. CSIT 2076 Batch</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1284" height="846" src="https://prime.edu.np/wp-content/uploads/2024/12/Inaugration_speech_for_ICT_Meetup.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/Inaugration_speech_for_ICT_Meetup.jpg 1284w, https://prime.edu.np/wp-content/uploads/2024/12/Inaugration_speech_for_ICT_Meetup-300x198.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/12/Inaugration_speech_for_ICT_Meetup-1024x675.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/12/Inaugration_speech_for_ICT_Meetup-768x506.jpg 768w" sizes="(max-width: 1284px) 100vw, 1284px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 20, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/supriya-thapa-bhujel-my-journey-leading-the-prime-it-club-bsc-csit-2076-batch/">Supriya Thapa Bhujel: My Journey Leading the Prime IT Club | BSc. CSIT 2076 Batch</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1280" height="960" src="https://prime.edu.np/wp-content/uploads/2024/12/470001839_561078000049786_629480348383715967_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/12/470001839_561078000049786_629480348383715967_n.jpg 1280w, https://prime.edu.np/wp-content/uploads/2024/12/470001839_561078000049786_629480348383715967_n-300x225.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/12/470001839_561078000049786_629480348383715967_n-1024x768.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/12/470001839_561078000049786_629480348383715967_n-768x576.jpg 768w" sizes="(max-width: 1280px) 100vw, 1280px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 18, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/21st-prime-sports-gala-2081-a-celebration-of-talent-teamwork-and-triumph/">21st Prime Sports Gala 2081: A Celebration of Talent, Teamwork, and Triumph </a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="798" height="600" src="https://prime.edu.np/wp-content/uploads/2024/11/original-121D23B7-3D27-4F38-B52A-A2011C67AC3B.jpeg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/11/original-121D23B7-3D27-4F38-B52A-A2011C67AC3B.jpeg 798w, https://prime.edu.np/wp-content/uploads/2024/11/original-121D23B7-3D27-4F38-B52A-A2011C67AC3B-300x226.jpeg 300w, https://prime.edu.np/wp-content/uploads/2024/11/original-121D23B7-3D27-4F38-B52A-A2011C67AC3B-768x577.jpeg 768w" sizes="(max-width: 798px) 100vw, 798px" />            </div>
            <div class="card-body">
              <div class="post-date">Nov 6, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/my-journey-as-the-president-of-prime-emc-prabesh-adhikari-bsc-csit-2076-batch/">My Journey as the President of Prime EMC | Prabesh Adhikari, BSc. CSIT 2076 Batch </a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2024/10/1001053618-scaled.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/10/1001053618-scaled.jpg 2560w, https://prime.edu.np/wp-content/uploads/2024/10/1001053618-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/10/1001053618-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/10/1001053618-768x512.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/10/1001053618-1536x1024.jpg 1536w, https://prime.edu.np/wp-content/uploads/2024/10/1001053618-2048x1365.jpg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 1, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/my-journey-of-growth-and-unforgettable-memories-at-prime-college-angelique-dangol-bbm-2076-batch/">My Journey of Growth and Unforgettable Memories at Prime College | Angelique Dangol, BBM 2076 Batch</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="720" src="https://prime.edu.np/wp-content/uploads/2024/09/IMG-20240909-WA0009.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/09/IMG-20240909-WA0009.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/09/IMG-20240909-WA0009-300x200.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/09/IMG-20240909-WA0009-1024x683.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/09/IMG-20240909-WA0009-768x512.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Sep 20, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/my-experience-at-prime-it-club-jenish-maharjan-bca-2076-batch/">My Experience at Prime IT Club | Jenish Maharjan, BCA 2076 Batch</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="620" height="480" src="https://prime.edu.np/wp-content/uploads/2024/09/Picture.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/09/Picture.jpg 620w, https://prime.edu.np/wp-content/uploads/2024/09/Picture-300x232.jpg 300w" sizes="(max-width: 620px) 100vw, 620px" />            </div>
            <div class="card-body">
              <div class="post-date">Sep 5, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/reflections-on-my-journey-at-prime-college-smriti-maharjan-bba-2076-batch/">Reflections on My Journey at Prime College | Smriti Maharjan, BBA 2076 Batch</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="468" height="351" src="https://prime.edu.np/wp-content/uploads/2024/08/e1.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/08/e1.jpg 468w, https://prime.edu.np/wp-content/uploads/2024/08/e1-300x225.jpg 300w" sizes="(max-width: 468px) 100vw, 468px" />            </div>
            <div class="card-body">
              <div class="post-date">Aug 30, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/this-experience-at-prime-college-was-a-game-changer-for-me-pushpa-kc-bba-2076-batch/">This experience at Prime College was a game-changer for me | Pushpa KC, BBA 2076 batch</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1800" height="1350" src="https://prime.edu.np/wp-content/uploads/2024/08/Water-distribution.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/08/Water-distribution.jpg 1800w, https://prime.edu.np/wp-content/uploads/2024/08/Water-distribution-300x225.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/08/Water-distribution-1024x768.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/08/Water-distribution-768x576.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/08/Water-distribution-1536x1152.jpg 1536w" sizes="(max-width: 1800px) 100vw, 1800px" />            </div>
            <div class="card-body">
              <div class="post-date">Aug 25, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/water-distribution-on-gunla-prime-cultural-club-and-prime-sic/">Water Distribution on Gunla | Prime Cultural Club and Prime SIC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1600" height="1200" src="https://prime.edu.np/wp-content/uploads/2024/08/WhatsApp-Image-2024-08-09-at-12.54.40 PM-1.jpeg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/08/WhatsApp-Image-2024-08-09-at-12.54.40 PM-1.jpeg 1600w, https://prime.edu.np/wp-content/uploads/2024/08/WhatsApp-Image-2024-08-09-at-12.54.40 PM-1-300x225.jpeg 300w, https://prime.edu.np/wp-content/uploads/2024/08/WhatsApp-Image-2024-08-09-at-12.54.40 PM-1-1024x768.jpeg 1024w, https://prime.edu.np/wp-content/uploads/2024/08/WhatsApp-Image-2024-08-09-at-12.54.40 PM-1-768x576.jpeg 768w, https://prime.edu.np/wp-content/uploads/2024/08/WhatsApp-Image-2024-08-09-at-12.54.40 PM-1-1536x1152.jpeg 1536w" sizes="(max-width: 1600px) 100vw, 1600px" />            </div>
            <div class="card-body">
              <div class="post-date">Aug 12, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/environmental-social-and-governance-esg-workshop-mlrc/">Environmental, Social, and Governance (ESG) Workshop | MLRC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="728" height="408" src="https://prime.edu.np/wp-content/uploads/2024/07/elegant-bridal-hands-stockcake.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/07/elegant-bridal-hands-stockcake.jpg 728w, https://prime.edu.np/wp-content/uploads/2024/07/elegant-bridal-hands-stockcake-300x168.jpg 300w" sizes="(max-width: 728px) 100vw, 728px" />            </div>
            <div class="card-body">
              <div class="post-date">Jul 7, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/rendezvous-sadikshya-sherchan-bba/">Rendezvous | Sadikshya Sherchan, BBA</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="957" height="1440" src="https://prime.edu.np/wp-content/uploads/2024/06/Snapchat-2133473591.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/06/Snapchat-2133473591.jpg 957w, https://prime.edu.np/wp-content/uploads/2024/06/Snapchat-2133473591-199x300.jpg 199w, https://prime.edu.np/wp-content/uploads/2024/06/Snapchat-2133473591-681x1024.jpg 681w, https://prime.edu.np/wp-content/uploads/2024/06/Snapchat-2133473591-768x1156.jpg 768w" sizes="(max-width: 957px) 100vw, 957px" />            </div>
            <div class="card-body">
              <div class="post-date">Jun 28, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/times-torment-ismail-ahmad-bim/">Time’s Torment | Smile Ahmed, BIM</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2047" height="1536" src="https://prime.edu.np/wp-content/uploads/2024/06/a1.jpeg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/06/a1.jpeg 2047w, https://prime.edu.np/wp-content/uploads/2024/06/a1-300x225.jpeg 300w, https://prime.edu.np/wp-content/uploads/2024/06/a1-1024x768.jpeg 1024w, https://prime.edu.np/wp-content/uploads/2024/06/a1-768x576.jpeg 768w, https://prime.edu.np/wp-content/uploads/2024/06/a1-1536x1153.jpeg 1536w" sizes="(max-width: 2047px) 100vw, 2047px" />            </div>
            <div class="card-body">
              <div class="post-date">Jun 28, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/cybersecurity-awareness-program-aavash-devkota-bsc-csit/">Cybersecurity Awareness Program | Aavash Devkota, BSc. CSIT</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1536" height="1536" src="https://prime.edu.np/wp-content/uploads/2024/06/Last-Day-1.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/06/Last-Day-1.jpg 1536w, https://prime.edu.np/wp-content/uploads/2024/06/Last-Day-1-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/06/Last-Day-1-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/06/Last-Day-1-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2024/06/Last-Day-1-768x768.jpg 768w" sizes="(max-width: 1536px) 100vw, 1536px" />            </div>
            <div class="card-body">
              <div class="post-date">Jun 25, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/emotional-intelligence-and-self-discovery-journey-through-a-workshop-experience-sumina-maharjan/">Emotional intelligence and self-discovery journey through a workshop experience | Sumina Maharjan</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1348" height="1011" src="https://prime.edu.np/wp-content/uploads/2024/05/8s02ck17WzKpZVRpFtiD2Fkglav6WArHLf5H5Y6e.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/05/8s02ck17WzKpZVRpFtiD2Fkglav6WArHLf5H5Y6e.jpg 1348w, https://prime.edu.np/wp-content/uploads/2024/05/8s02ck17WzKpZVRpFtiD2Fkglav6WArHLf5H5Y6e-300x225.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/05/8s02ck17WzKpZVRpFtiD2Fkglav6WArHLf5H5Y6e-1024x768.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/05/8s02ck17WzKpZVRpFtiD2Fkglav6WArHLf5H5Y6e-768x576.jpg 768w" sizes="(max-width: 1348px) 100vw, 1348px" />            </div>
            <div class="card-body">
              <div class="post-date">May 30, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/empowering-girls-through-tech-the-ms-office-workshop-journey-niva-maharjan-prime-it-club/">Empowering Girls through Tech: The MS Office Workshop Journey | Niva Maharjan | Prime IT Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1600" height="1200" src="https://prime.edu.np/wp-content/uploads/2024/02/durga-4.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/02/durga-4.jpg 1600w, https://prime.edu.np/wp-content/uploads/2024/02/durga-4-300x225.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/02/durga-4-1024x768.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/02/durga-4-768x576.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/02/durga-4-1536x1152.jpg 1536w" sizes="(max-width: 1600px) 100vw, 1600px" />            </div>
            <div class="card-body">
              <div class="post-date">Feb 15, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/a-day-out-with-prime-family-durga-thapa/">A day out with Prime Family | Durga Thapa</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2048" height="1146" src="https://prime.edu.np/wp-content/uploads/2024/02/425003817_359838886840366_5266617936931921540_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/02/425003817_359838886840366_5266617936931921540_n.jpg 2048w, https://prime.edu.np/wp-content/uploads/2024/02/425003817_359838886840366_5266617936931921540_n-300x168.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/02/425003817_359838886840366_5266617936931921540_n-1024x573.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/02/425003817_359838886840366_5266617936931921540_n-768x430.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/02/425003817_359838886840366_5266617936931921540_n-1536x860.jpg 1536w" sizes="(max-width: 2048px) 100vw, 2048px" />            </div>
            <div class="card-body">
              <div class="post-date">Feb 13, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/prime-inter-college-student-club-meet-up-fostering-collaboration-and-community-building-among-student-community-mlrc/">Fostering Collaboration and Community Building Among Student Community | MLRC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1080" src="https://prime.edu.np/wp-content/uploads/2024/02/415447653_838297254972661_6869031890492629374_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/02/415447653_838297254972661_6869031890492629374_n.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/02/415447653_838297254972661_6869031890492629374_n-300x300.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/02/415447653_838297254972661_6869031890492629374_n-1024x1024.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/02/415447653_838297254972661_6869031890492629374_n-150x150.jpg 150w, https://prime.edu.np/wp-content/uploads/2024/02/415447653_838297254972661_6869031890492629374_n-768x768.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Feb 12, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/spreading-joy-a-recap-of-the-smile-for-all-christmas-event-mlrc/">Spreading Joy: A Recap of the Smile for All-Christmas Event | MLRC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1080" height="1351" src="https://prime.edu.np/wp-content/uploads/2024/02/martin-1.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/02/martin-1.jpg 1080w, https://prime.edu.np/wp-content/uploads/2024/02/martin-1-240x300.jpg 240w, https://prime.edu.np/wp-content/uploads/2024/02/martin-1-819x1024.jpg 819w, https://prime.edu.np/wp-content/uploads/2024/02/martin-1-768x961.jpg 768w" sizes="(max-width: 1080px) 100vw, 1080px" />            </div>
            <div class="card-body">
              <div class="post-date">Feb 11, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/music-for-cause-vol-ii-a-harmonious-journey-of-giving-back-mlrc/">Music For Cause Vol-II: A Harmonious Journey of Giving Back | MLRC</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1600" height="1200" src="https://prime.edu.np/wp-content/uploads/2024/01/0-02-03-f43e114833019193195e84679d12f6aa8e963265ce6bf9326799b97b6fe27d9c_b8cc2f06ead43179.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/01/0-02-03-f43e114833019193195e84679d12f6aa8e963265ce6bf9326799b97b6fe27d9c_b8cc2f06ead43179.jpg 1600w, https://prime.edu.np/wp-content/uploads/2024/01/0-02-03-f43e114833019193195e84679d12f6aa8e963265ce6bf9326799b97b6fe27d9c_b8cc2f06ead43179-300x225.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/01/0-02-03-f43e114833019193195e84679d12f6aa8e963265ce6bf9326799b97b6fe27d9c_b8cc2f06ead43179-1024x768.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/01/0-02-03-f43e114833019193195e84679d12f6aa8e963265ce6bf9326799b97b6fe27d9c_b8cc2f06ead43179-768x576.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/01/0-02-03-f43e114833019193195e84679d12f6aa8e963265ce6bf9326799b97b6fe27d9c_b8cc2f06ead43179-1536x1152.jpg 1536w" sizes="(max-width: 1600px) 100vw, 1600px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 19, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/prime-picnic-program-at-switzerland-park-rina-chakubaji/">Prime Picnic Program at Switzerland Park | Rina Chakubaji</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2048" height="1536" src="https://prime.edu.np/wp-content/uploads/2024/01/417106697_1094830374981258_6512159591985763915_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/01/417106697_1094830374981258_6512159591985763915_n.jpg 2048w, https://prime.edu.np/wp-content/uploads/2024/01/417106697_1094830374981258_6512159591985763915_n-300x225.jpg 300w, https://prime.edu.np/wp-content/uploads/2024/01/417106697_1094830374981258_6512159591985763915_n-1024x768.jpg 1024w, https://prime.edu.np/wp-content/uploads/2024/01/417106697_1094830374981258_6512159591985763915_n-768x576.jpg 768w, https://prime.edu.np/wp-content/uploads/2024/01/417106697_1094830374981258_6512159591985763915_n-1536x1152.jpg 1536w" sizes="(max-width: 2048px) 100vw, 2048px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 18, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/a-memorable-getaway-to-chitlang-samyukta-silakar/">A Memorable Getaway to Chitlang | Samyukta Silakar</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2560" height="1707" src="https://prime.edu.np/wp-content/uploads/2024/01/81e979a2-3719-4b48-997a-54a76487001c-scaled.jpeg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2024/01/81e979a2-3719-4b48-997a-54a76487001c-scaled.jpeg 2560w, https://prime.edu.np/wp-content/uploads/2024/01/81e979a2-3719-4b48-997a-54a76487001c-300x200.jpeg 300w, https://prime.edu.np/wp-content/uploads/2024/01/81e979a2-3719-4b48-997a-54a76487001c-1024x683.jpeg 1024w, https://prime.edu.np/wp-content/uploads/2024/01/81e979a2-3719-4b48-997a-54a76487001c-768x512.jpeg 768w, https://prime.edu.np/wp-content/uploads/2024/01/81e979a2-3719-4b48-997a-54a76487001c-1536x1024.jpeg 1536w, https://prime.edu.np/wp-content/uploads/2024/01/81e979a2-3719-4b48-997a-54a76487001c-2048x1365.jpeg 2048w" sizes="(max-width: 2560px) 100vw, 2560px" />            </div>
            <div class="card-body">
              <div class="post-date">Jan 17, 2024</div>
              <h4><a href="https://prime.edu.np/prime_blog/prime-college-experiences-and-lessons/">Prime College: Experiences and Lessons | Minasha Maharjan</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1440" height="810" src="https://prime.edu.np/wp-content/uploads/2023/12/370781894_704084008428820_884519767836668513_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/12/370781894_704084008428820_884519767836668513_n.jpg 1440w, https://prime.edu.np/wp-content/uploads/2023/12/370781894_704084008428820_884519767836668513_n-300x169.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/12/370781894_704084008428820_884519767836668513_n-1024x576.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/12/370781894_704084008428820_884519767836668513_n-768x432.jpg 768w" sizes="(max-width: 1440px) 100vw, 1440px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 12, 2023</div>
              <h4><a href="https://prime.edu.np/prime_blog/harmony-in-diversity-neeti-tamrakars-journey-with-prime-cultural-club/">Harmony in Diversity: Neeti Tamrakar&#8217;s Journey with Prime Cultural Club</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="999" height="666" src="https://prime.edu.np/wp-content/uploads/2023/10/image-31.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/10/image-31.png 999w, https://prime.edu.np/wp-content/uploads/2023/10/image-31-300x200.png 300w, https://prime.edu.np/wp-content/uploads/2023/10/image-31-768x512.png 768w" sizes="(max-width: 999px) 100vw, 999px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 16, 2023</div>
              <h4><a href="https://prime.edu.np/prime_blog/my-leadership-journey-at-prime-emc-a-year-of-growth-and-impact/">My Leadership Journey at Prime EMC: A Year of Growth and Impact | Swastika Banskota</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="2048" height="1536" src="https://prime.edu.np/wp-content/uploads/2023/10/361607899_665423745614898_221608660978922055_n-1.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/10/361607899_665423745614898_221608660978922055_n-1.jpg 2048w, https://prime.edu.np/wp-content/uploads/2023/10/361607899_665423745614898_221608660978922055_n-1-300x225.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/10/361607899_665423745614898_221608660978922055_n-1-1024x768.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/10/361607899_665423745614898_221608660978922055_n-1-768x576.jpg 768w, https://prime.edu.np/wp-content/uploads/2023/10/361607899_665423745614898_221608660978922055_n-1-1536x1152.jpg 1536w" sizes="(max-width: 2048px) 100vw, 2048px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 11, 2023</div>
              <h4><a href="https://prime.edu.np/prime_blog/unveiling-the-leadership-journey-of-pramila-shrestha/">Unveiling the Leadership Journey of Pramila Shrestha, President of Prime IT Club (2022-2023) | Niraj Thapa Magar</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="999" height="562" src="https://prime.edu.np/wp-content/uploads/2023/10/image-1.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/10/image-1.png 999w, https://prime.edu.np/wp-content/uploads/2023/10/image-1-300x169.png 300w, https://prime.edu.np/wp-content/uploads/2023/10/image-1-768x432.png 768w" sizes="(max-width: 999px) 100vw, 999px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 9, 2023</div>
              <h4><a href="https://prime.edu.np/prime_blog/bba-7th-semesters-sustainable-city-project/">BBA 7th Semester&#8217;s Sustainable City Project | Niraj Thapa Magar</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1192" height="810" src="https://prime.edu.np/wp-content/uploads/2023/09/kathmandu-milk.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/09/kathmandu-milk.png 1192w, https://prime.edu.np/wp-content/uploads/2023/09/kathmandu-milk-300x204.png 300w, https://prime.edu.np/wp-content/uploads/2023/09/kathmandu-milk-1024x696.png 1024w, https://prime.edu.np/wp-content/uploads/2023/09/kathmandu-milk-768x522.png 768w" sizes="(max-width: 1192px) 100vw, 1192px" />            </div>
            <div class="card-body">
              <div class="post-date">Sep 5, 2023</div>
              <h4><a href="https://prime.edu.np/prime_blog/debunking-the-myth-unveiling-the-truth-about-packaged-milk/">Debunking the Myth: Unveiling the Truth about Packaged Milk | Niraj Thapa Magar</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="326" height="254" src="https://prime.edu.np/wp-content/uploads/2023/12/image-9.png" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/12/image-9.png 326w, https://prime.edu.np/wp-content/uploads/2023/12/image-9-300x234.png 300w" sizes="(max-width: 326px) 100vw, 326px" />            </div>
            <div class="card-body">
              <div class="post-date">Dec 15, 2022</div>
              <h4><a href="https://prime.edu.np/prime_blog/internship-at-prime-college-juneli-sunar/">Internship At Prime College | Juneli Sunar</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1604" height="2560" src="https://prime.edu.np/wp-content/uploads/2023/12/You-are-Beautiful-scaled.jpeg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/12/You-are-Beautiful-scaled.jpeg 1604w, https://prime.edu.np/wp-content/uploads/2023/12/You-are-Beautiful-188x300.jpeg 188w, https://prime.edu.np/wp-content/uploads/2023/12/You-are-Beautiful-642x1024.jpeg 642w, https://prime.edu.np/wp-content/uploads/2023/12/You-are-Beautiful-768x1225.jpeg 768w, https://prime.edu.np/wp-content/uploads/2023/12/You-are-Beautiful-963x1536.jpeg 963w, https://prime.edu.np/wp-content/uploads/2023/12/You-are-Beautiful-1283x2048.jpeg 1283w" sizes="(max-width: 1604px) 100vw, 1604px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 31, 2022</div>
              <h4><a href="https://prime.edu.np/prime_blog/you-are-beautiful-swastika-banskota/">You Are Beautiful | Swastika Banskota</a></h4>
            </div>
          </div>
        </div>
                <div class="swiper-slide news-event-slider-item">
          <div class="card news-event-card">
            <div class="card-img">
             <img width="1024" height="577" src="https://prime.edu.np/wp-content/uploads/2023/10/159865420_3667208353348504_2712345859807409217_n.jpg" class="attachment-post-thumbnail size-post-thumbnail wp-post-image" alt="" decoding="async" srcset="https://prime.edu.np/wp-content/uploads/2023/10/159865420_3667208353348504_2712345859807409217_n.jpg 1024w, https://prime.edu.np/wp-content/uploads/2023/10/159865420_3667208353348504_2712345859807409217_n-300x169.jpg 300w, https://prime.edu.np/wp-content/uploads/2023/10/159865420_3667208353348504_2712345859807409217_n-768x433.jpg 768w" sizes="(max-width: 1024px) 100vw, 1024px" />            </div>
            <div class="card-body">
              <div class="post-date">Oct 20, 2022</div>
              <h4><a href="https://prime.edu.np/prime_blog/actual-diary-never-to-forget-juneli-sunar/">Actual Diary Never to Forget | Juneli Sunar</a></h4>
            </div>
          </div>
        </div>
              </div>
    </div>
  </div>
    <div class="mt-4 text-center">
      <a href="https://prime.edu.np/prime-blog" class="btn btn-primary">See All Blogs</a>
  </div>
</div>
<!--End Prime Blog-->



<!-- Start Our Partner -->
<div class="our-Partner-section block">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="section-head">
          <h2 class="section-title text-center">
           Our Partners          </h2>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <ul class="nav nav-pills" id="pills-tab" role="tablist">
          <li class="nav-item" role="presentation">
            <button class="nav-link active" id="pills-home-tab" data-bs-toggle="pill" data-bs-target="#pills-home" type="button" role="tab" aria-controls="pills-home" aria-selected="true">Prime Privilege Partner</button>
          </li>
          <li class="nav-item" role="presentation">
            <button class="nav-link" id="pills-profile-tab" data-bs-toggle="pill" data-bs-target="#pills-profile" type="button" role="tab" aria-controls="pills-profile" aria-selected="false">Prime Career Partner</button>
          </li>
          <li class="nav-item" role="presentation">
            <button class="nav-link" id="pills-contact-tab" data-bs-toggle="pill" data-bs-target="#pills-contact" type="button" role="tab" aria-controls="pills-contact" aria-selected="false">Prime Worldwide Partner</button>
          </li>
        </ul>
        <div class="tab-content" id="pills-tabContent">
          <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab" tabindex="0">
              <div class="swiper partner-slider">
  <!-- Additional required wrapper -->
  <div class="swiper-wrapper">
    <!-- Slides -->
                  <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/07/cafenlava.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/07/morison.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/08/logo.png" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/07/mlight.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/07/wdn.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/08/350.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/08/The-Dairy-Station-Logo.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/08/washmandu.png" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/08/sowa.png" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/08/bluec.png" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/09/kpl.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/07/beernnuts.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/08/studio.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/08/Be-Legend-Shapes-Gym-Logo-scaled.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2023/08/Devi-Chandima-Electronics-Vector-Image.png" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2024/05/Bo-Bo-E-Games-Logo.png" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2024/05/Detroit-4-Corners-Pizza-Logo.jpeg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2024/06/Fatafat-Logo-scaled.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2024/06/Happy-Bites-Logo.png" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2024/06/Kalanki-Gym-Center-Logo.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2024/06/Swimfit-Nepal-Logo1.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2024/07/The-Bell-Bar-and-Bistro-Logo.jpg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2024/07/OOPS-NEPAL-LOGO.png" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2024/09/Mirch-Hospitality-Logo.jpeg" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2025/01/We-Care-Health-Center-logo.png" alt="#"></a></div>
                            <div class="swiper-slide"><a href="https://prime.edu.np/prime-privilege-partners/" target="_blank"><img src="https://prime.edu.np/wp-content/uploads/2025/01/Vanity-Men-Logo-1.png" alt="#"></a></div>
               
  </div>
</div>
            
                  
            </div>
          <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab" tabindex="0">
              <div class="swiper partner-slider">
  <!-- Additional required wrapper -->
  <div class="swiper-wrapper">
    <!-- Slides -->
                  <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/07/midas.jpg" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/07/sct.jpg" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/07/tow.jpg" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/08/Screenshot_145.png" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/08/Screenshot_144.png" alt="#"></div>
               
  </div>
</div>
          </div>
          <div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab" tabindex="0">
               <div class="swiper partner-slider">
  <!-- Additional required wrapper -->
  <div class="swiper-wrapper">
    <!-- Slides -->
                  <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/07/cisco.jpg" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/07/nren.jpg" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/07/office.jpg" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/07/HA.jpg" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2024/07/AIT_globe.webp" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2025/01/Vector-Smart-Object.svg" alt="#"></div>
                            <div class="swiper-slide"><img src="https://prime.edu.np/wp-content/uploads/2023/08/Screenshot_148.png" alt="#"></div>
               
  </div>
</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- End Our Partner -->



	<!-- Start Footer -->
<footer>
  <div class="footer-top">
    <div class="container">
      <div class="row">
        <div class="col-md-6 col-lg-3">
          <div class="footer-item">
            <a href="https://prime.edu.np" class="footer-logo">
              <img src="https://prime.edu.np/wp-content/uploads/2023/09/Prime-College-Logo.svg" alt="logo">
            </a>
            <ul class="footer-contact">
              <li>Khusibun, Nayabazar, Kathmandu</li>
              <li><a href="tel:01-4961690">01-4961690</a>, <a href="tel:01-4970072">01-4970072</a></li>
              <li><a href="/cdn-cgi/l/email-protection#d2bbbcb4bd92a2a0bbbfb7fcb7b6a7fcbca2"><span class="__cf_email__" data-cfemail="1b72757d745b6b6972767e357e7f6e35756b">[email&#160;protected]</span></a>,   <a href="/cdn-cgi/l/email-protection#4c2d2821253f3f2523223f0c3c3e2521296229283962223c6c"><span class="__cf_email__" data-cfemail="e8898c85819b9b8187869ba8989a81858dc68d8c9dc68698">[email&#160;protected]</span>  </a></li>
              <li><p>You can visit Prime College between 7:00 a.m. - 5:00 p.m. for more information.</p></li>
            </ul>
            <h5>Join Our Community</h5>
            <ul class="si-wrap">
      <li><a href="https://www.facebook.com/primecollegenp" target="_blank"><i class="fa-brands fa-facebook-f"></i></a></li>
          <li><a href="https://www.youtube.com/user/primecollege1" target="_blank"><i class="fa-brands fa-youtube"></i></a></li>
          <li><a href="https://www.instagram.com/prime__college/?hl=en" target="_blank"><i class="fa-brands fa-instagram"></i></a></li>
          <li><a href="https://np.linkedin.com/company/prime-college-nepal" target="_blank"><i class="fa-brands fa-linkedin-in"></i></a></li>
          <li><a href="https://www.tiktok.com/@prime_college" target="_blank"><i class="fa-brands fa-tiktok"></i></a></li>
        </ul>
          </div>
        </div>
        <div class="col-md-6 col-lg-3">
          <div class="footer-item">
            <h6>Quick Links</h6>
             <ul id="menu-quick-links" class="menu"><li id="menu-item-494" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-494"><a href="https://prime.edu.np/faq/">FAQ</a></li>
<li id="menu-item-577" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-577"><a href="https://prime.edu.np/mlrc/">MLRC</a></li>
<li id="menu-item-576" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-576"><a href="https://prime.edu.np/eso/">ESO</a></li>
<li id="menu-item-1125" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1125"><a href="https://prime.edu.np/career/">Prime Career Center</a></li>
<li id="menu-item-1126" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1126"><a href="https://prime.edu.np/team/">Know Our Team</a></li>
<li id="menu-item-493" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-493"><a href="https://prime.edu.np/about/">Who We Are</a></li>
<li id="menu-item-1127" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1127"><a href="https://prime.edu.np/character-certificate-form/">Character Certificate Form</a></li>
<li id="menu-item-1128" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1128"><a href="https://prime.edu.np/hall-booking/">Seminar Hall Booking</a></li>
<li id="menu-item-495" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-495"><a href="https://prime.edu.np/apply-now/">Apply Now</a></li>
</ul>          </div>
        </div>
        <div class="col-md-6 col-lg-3">
          <div class="footer-item">
            <h6>Bachelor Programs</h6>
             <ul id="menu-footer-program-menu" class="menu"><li id="menu-item-876" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-876"><a href="https://prime.edu.np/program/bachelor-of-business-studies/">BBS</a></li>
<li id="menu-item-877" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-877"><a href="https://prime.edu.np/program/bbm/">BBM</a></li>
<li id="menu-item-878" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-878"><a href="https://prime.edu.np/program/bim/">BIM</a></li>
<li id="menu-item-879" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-879"><a href="https://prime.edu.np/program/bachelor-of-business-administration/">BBA</a></li>
<li id="menu-item-880" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-880"><a href="https://prime.edu.np/program/bachelor-of-computer-applications/">BCA</a></li>
<li id="menu-item-881" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-881"><a href="https://prime.edu.np/program/bachelors-of-science-in-csit/">BSc. CSIT</a></li>
</ul>          </div>
        </div>
        <div class="col-md-6 col-lg-3">
          <div class="footer-item">
            <h6>Master Program</h6>
             <ul id="menu-footer-master-menu" class="menu"><li id="menu-item-882" class="menu-item menu-item-type-post_type menu-item-object-program menu-item-882"><a href="https://prime.edu.np/program/mbs/">MBS</a></li>
</ul>          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="footer-btm">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <p>© 2025 Prime College. All Rights Reserved. Website Designed & Developed by <a href="https://themenepal.com/">Theme Nepal</a></p>
        </div>
        <!--<div class="col-md-6 text-lg-end">-->
        <!--  <p>Website Designed & Developed by <a href="https://themenepal.com/">Theme Nepal</a></p>-->
        <!--</div>-->
      </div>
    </div>
  </div>
</footer>
<!-- End Footer -->



<!-- GetButton.io widget -->
<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script type="text/javascript">
(function () {
var options = {
            facebook: "100071046916926", 
            whatsapp: "+977-9820112011", 
            call_to_action: "Message us", 
            button_color: "#f4be40", 
            position: "right", 
            order: "whatsapp,viber,facebook", 
        };
    var proto = 'https:', host = "getbutton.io", url = proto + '//static.' + host;
    var s = document.createElement('script'); s.type = 'text/javascript'; s.async = true; s.src = url + '/widget-send-button/js/init.js';
    s.onload = function () { WhWidgetSendButton.init(host, proto, options); };
    var x = document.getElementsByTagName('script')[0]; x.parentNode.insertBefore(s, x);
})();
</script>
<!-- /GetButton.io widget -->


<!-- WP Socializer 7.9 - JS - Start -->

<!-- WP Socializer - JS - End -->
<div class="wp-socializer wpsr-follow-icons sr-fb-rm sr-fb-vl" data-lg-action="show" data-sm-action="show" data-sm-width="768"><div class="socializer sr-followbar sr-32px sr-drop sr-zoom sr-pad sr-vertical"><span class="sr-facebook"><a data-id="facebook" style="color:#ffffff;" rel="nofollow me" href="https://www.facebook.com/primecollegenp" target="_blank" title="Facebook"><i class="fab fa-facebook-f"></i></a></span><span class="sr-youtube"><a data-id="youtube" style="color:#ffffff;" rel="nofollow me" href="https://www.youtube.com/user/primecollege1" target="_blank" title="Youtube"><i class="fab fa-youtube"></i></a></span><span class="sr-instagram"><a data-id="instagram" style="color:#ffffff;" rel="nofollow me" href="https://www.instagram.com/prime__college/?hl=en" target="_blank" title="Instagram"><i class="fab fa-instagram"></i></a></span><span class="sr-linkedin"><a data-id="linkedin" style="color:#ffffff;" rel="nofollow me" href="https://np.linkedin.com/company/prime-college-nepal" target="_blank" title="LinkedIn"><i class="fab fa-linkedin-in"></i></a></span><span class="sr-tiktok"><a data-id="tiktok" style="color:#ffffff;" rel="nofollow me" href="https://www.tiktok.com/@prime_college" target="_blank" title="TikTok"><i class="fab fa-tiktok"></i></a></span></div><div class="wpsr-fb-close wpsr-close-btn" title="Open or close follow icons"><span class="wpsr-bar-icon"><svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" viewBox="0 0 16 16" class="i-open"><path d="M15,6h-5V1c0-0.55-0.45-1-1-1H7C6.45,0,6,0.45,6,1v5H1C0.45,6,0,6.45,0,7v2c0,0.55,0.45,1,1,1h5v5c0,0.55,0.45,1,1,1h2 c0.55,0,1-0.45,1-1v-5h5c0.55,0,1-0.45,1-1V7C16,6.45,15.55,6,15,6z"/></svg><svg class="i-close" xmlns="http://www.w3.org/2000/svg" width="10" height="10" viewBox="0 0 512 512"><path d="M417.4,224H94.6C77.7,224,64,238.3,64,256c0,17.7,13.7,32,30.6,32h322.8c16.9,0,30.6-14.3,30.6-32 C448,238.3,434.3,224,417.4,224z"/></svg></span></div></div><div id="pum-2316" role="dialog" aria-modal="false"  class="pum pum-overlay pum-theme-2307 pum-theme-default-theme popmake-overlay pum-click-to-close auto_open click_open" data-popmake="{&quot;id&quot;:2316,&quot;slug&quot;:&quot;pc-counselling-open-2081&quot;,&quot;theme_id&quot;:2307,&quot;cookies&quot;:[{&quot;event&quot;:&quot;on_popup_close&quot;,&quot;settings&quot;:{&quot;name&quot;:&quot;pum-2316&quot;,&quot;key&quot;:&quot;&quot;,&quot;session&quot;:null,&quot;path&quot;:true,&quot;time&quot;:&quot;1 sec&quot;}}],&quot;triggers&quot;:[{&quot;type&quot;:&quot;auto_open&quot;,&quot;settings&quot;:{&quot;cookie_name&quot;:[&quot;pum-2316&quot;],&quot;delay&quot;:&quot;500&quot;}},{&quot;type&quot;:&quot;click_open&quot;,&quot;settings&quot;:{&quot;extra_selectors&quot;:&quot;&quot;,&quot;cookie_name&quot;:null}}],&quot;mobile_disabled&quot;:null,&quot;tablet_disabled&quot;:null,&quot;meta&quot;:{&quot;display&quot;:{&quot;stackable&quot;:false,&quot;overlay_disabled&quot;:false,&quot;scrollable_content&quot;:false,&quot;disable_reposition&quot;:false,&quot;size&quot;:&quot;medium&quot;,&quot;responsive_min_width&quot;:&quot;0%&quot;,&quot;responsive_min_width_unit&quot;:false,&quot;responsive_max_width&quot;:&quot;100%&quot;,&quot;responsive_max_width_unit&quot;:false,&quot;custom_width&quot;:&quot;640px&quot;,&quot;custom_width_unit&quot;:false,&quot;custom_height&quot;:&quot;380px&quot;,&quot;custom_height_unit&quot;:false,&quot;custom_height_auto&quot;:false,&quot;location&quot;:&quot;center&quot;,&quot;position_from_trigger&quot;:false,&quot;position_top&quot;:&quot;100&quot;,&quot;position_left&quot;:&quot;0&quot;,&quot;position_bottom&quot;:&quot;0&quot;,&quot;position_right&quot;:&quot;0&quot;,&quot;position_fixed&quot;:false,&quot;animation_type&quot;:&quot;fade&quot;,&quot;animation_speed&quot;:&quot;350&quot;,&quot;animation_origin&quot;:&quot;center top&quot;,&quot;overlay_zindex&quot;:false,&quot;zindex&quot;:&quot;1999999999&quot;},&quot;close&quot;:{&quot;text&quot;:&quot;&quot;,&quot;button_delay&quot;:&quot;500&quot;,&quot;overlay_click&quot;:&quot;1&quot;,&quot;esc_press&quot;:false,&quot;f4_press&quot;:false},&quot;click_open&quot;:[]}}">

	<div id="popmake-2316" class="pum-container popmake theme-2307 pum-responsive pum-responsive-medium responsive size-medium">

				
				
		
				<div class="pum-content popmake-content" tabindex="0">
			<h2 style="text-align: center;"></h2>
<p><img fetchpriority="high" decoding="async" class="alignnone wp-image-3177 size-full" src="https://prime.edu.np/wp-content/uploads/2024/03/Counselling_Open_1.1_.png" alt="" width="1080" height="1080" srcset="https://prime.edu.np/wp-content/uploads/2024/03/Counselling_Open_1.1_.png 1080w, https://prime.edu.np/wp-content/uploads/2024/03/Counselling_Open_1.1_-300x300.png 300w, https://prime.edu.np/wp-content/uploads/2024/03/Counselling_Open_1.1_-1024x1024.png 1024w, https://prime.edu.np/wp-content/uploads/2024/03/Counselling_Open_1.1_-150x150.png 150w, https://prime.edu.np/wp-content/uploads/2024/03/Counselling_Open_1.1_-768x768.png 768w" sizes="(max-width: 1080px) 100vw, 1080px" /></p>
<h4 style="text-align: center;"><a href="https://prime.edu.np/apply-now/" target="_blank" rel="noopener">For Inquiry &#8211; </a><a href="https://prime.edu.np/apply-now/"> </a><a href="https://prime.edu.np/apply-now/" target="_blank" rel="noopener">https://prime.edu.np/apply-now/</a></h4>
		</div>

				
							<button type="button" class="pum-close popmake-close" aria-label="Close">
			CLOSE			</button>
		
	</div>

</div>
<script src="https://prime.edu.np/wp-includes/js/dist/hooks.min.js?ver=4d63a3d491d11ffd8ac6" id="wp-hooks-js"></script>
<script src="https://prime.edu.np/wp-includes/js/dist/i18n.min.js?ver=5e580eb46a90c2b997e6" id="wp-i18n-js"></script>
<script id="wp-i18n-js-after">
wp.i18n.setLocaleData( { 'text direction\u0004ltr': [ 'ltr' ] } );
</script>
<script src="https://prime.edu.np/wp-content/plugins/contact-form-7/includes/swv/js/index.js?ver=6.0.3" id="swv-js"></script>
<script id="contact-form-7-js-before">
var wpcf7 = {
    "api": {
        "root": "https:\/\/prime.edu.np\/wp-json\/",
        "namespace": "contact-form-7\/v1"
    },
    "cached": 1
};
</script>
<script src="https://prime.edu.np/wp-content/plugins/contact-form-7/includes/js/index.js?ver=6.0.3" id="contact-form-7-js"></script>
<script src="https://prime.edu.np/wp-content/themes/prime-college/js/navigation.js?ver=1.0.0" id="prime-college-navigation-js"></script>
<script src="https://prime.edu.np/wp-includes/js/jquery/ui/core.min.js?ver=1.13.3" id="jquery-ui-core-js"></script>
<script id="popup-maker-site-js-extra">
var pum_vars = {"version":"1.20.3","pm_dir_url":"https:\/\/prime.edu.np\/wp-content\/plugins\/popup-maker\/","ajaxurl":"https:\/\/prime.edu.np\/wp-admin\/admin-ajax.php","restapi":"https:\/\/prime.edu.np\/wp-json\/pum\/v1","rest_nonce":null,"default_theme":"2307","debug_mode":"","disable_tracking":"","home_url":"\/","message_position":"top","core_sub_forms_enabled":"1","popups":[],"cookie_domain":"","analytics_route":"analytics","analytics_api":"https:\/\/prime.edu.np\/wp-json\/pum\/v1"};
var pum_sub_vars = {"ajaxurl":"https:\/\/prime.edu.np\/wp-admin\/admin-ajax.php","message_position":"top"};
var pum_popups = {"pum-2316":{"triggers":[{"type":"auto_open","settings":{"cookie_name":["pum-2316"],"delay":"500"}}],"cookies":[{"event":"on_popup_close","settings":{"name":"pum-2316","key":"","session":null,"path":true,"time":"1 sec"}}],"disable_on_mobile":false,"disable_on_tablet":false,"atc_promotion":null,"explain":null,"type_section":null,"theme_id":"2307","size":"medium","responsive_min_width":"0%","responsive_max_width":"100%","custom_width":"640px","custom_height_auto":false,"custom_height":"380px","scrollable_content":false,"animation_type":"fade","animation_speed":"350","animation_origin":"center top","open_sound":"none","custom_sound":"","location":"center","position_top":"100","position_bottom":"0","position_left":"0","position_right":"0","position_from_trigger":false,"position_fixed":false,"overlay_disabled":false,"stackable":false,"disable_reposition":false,"zindex":"1999999999","close_button_delay":"500","fi_promotion":null,"close_on_form_submission":true,"close_on_form_submission_delay":"0","close_on_overlay_click":true,"close_on_esc_press":false,"close_on_f4_press":false,"disable_form_reopen":false,"disable_accessibility":false,"theme_slug":"default-theme","id":2316,"slug":"pc-counselling-open-2081"}};
</script>
<script src="https://prime.edu.np/wp-content/plugins/popup-maker/assets/js/site.min.js?defer&amp;ver=1.20.3" id="popup-maker-site-js"></script>
<script id="wpsr_main_js-js-extra">
var wp_socializer = {"ajax_url":"https:\/\/prime.edu.np\/wp-admin\/admin-ajax.php"};
</script>
<script src="https://prime.edu.np/wp-content/plugins/wp-socializer/public/js/wp-socializer.min.js?ver=7.9" id="wpsr_main_js-js"></script>
<!-- ----------Scripts--------- -->
<script src="https://prime.edu.np/wp-content/themes/prime-college/assets/js/jquery-3.7.0.min.js"></script>
    <script src="https://prime.edu.np/wp-content/themes/prime-college/assets/js/bootstrap.bundle.min.js"></script>
    <script src="https://prime.edu.np/wp-content/themes/prime-college/assets/vendor/fontawesome/js/all.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
    <script src="https://prime.edu.np/wp-content/themes/prime-college/assets/vendor/fancybox/jquery.fancybox.min.js"></script>
    <script src="https://prime.edu.np/wp-content/themes/prime-college/assets/vendor/jquery.matchHeight-min.js"></script>
    <script src="https://prime.edu.np/wp-content/themes/prime-college/assets/js/script.js"></script>
    
    <script>
        $(document).ready(function(){
        $(".fancybox").fancybox({
}); 
}); 
    </script>
   

<script>
    $(document).ready(function(){
        // Our Program Slider
  var programswiper = new Swiper(".our-program-slider", {
      loop: true,
      loopedSlides:1,
    spaceBetween: 10,
    slidesPerView: 1,
    speed:1000,
    autoplay: {
      delay: 2500,
      disableOnInteraction: false,
    },
    
    breakpoints: {
      640: {
        slidesPerView: 2,
        loopedSlides:2,
        spaceBetween: 20,
      },
      768: {
        slidesPerView: 3,
        loopedSlides:3,
      },
      1024: {
        slidesPerView: 4,
        loopedSlides:4,
        spaceBetween: 30,
      },
    },
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },
  });
    });
</script>

</body>
</html>

```
---
