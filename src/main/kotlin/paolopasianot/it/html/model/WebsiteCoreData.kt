package paolopasianot.it.html.model

import kotlinx.html.HEAD
import kotlinx.html.link
import kotlinx.html.meta

/**
 * General information for webpage
 */
data class WebsiteCoreData(
    val lang: SupportedLangs,
    val theme: Theme,
    val title: String,
    val icon: Icon
){
    data class Icon (
        val faviconRootPath: String,
        val icon32: String = "/favicon-32x32.png",
        val icon16: String? = "/favicon-16x16.png",
        val appleTouchIcon: String? = "/apple-touch-icon.png",
        val manifest: String? = "/site.webmanifest",
        val maskIcon: String? = "/safari-pinned-tab.svg",
        val maskColor: String? = "#5bbad5",
        val msApplicationTitleColor: String? = "#da532c",
        val themeColor: String? = "#ffffff"
    )
}

enum class Theme{
    LIGHT, DARK
}

enum class SupportedLangs(
    val toHTML: String
){
    IT(toHTML = "IT")
}


/**
 * Write in html head the favicon information based from [WebsiteCoreData.Icon] information
 */
fun HEAD.favicon(iconData: WebsiteCoreData.Icon){
    //Icon 32x32
    link(rel = "icon", type = "image/png", href = "${iconData.faviconRootPath}/${iconData.icon32}"){
        sizes = "32x32"
    }
    //Icon 16x16
    iconData.icon16?.let { icon ->
        link(rel = "icon", type = "image/png", href = "${iconData.faviconRootPath}/$icon"){
            sizes = "16x16"
        }
    }
    //Apple
    iconData.appleTouchIcon?.let { icon ->
        link(rel = "apple-touch-icon", href = "${iconData.faviconRootPath}/$icon"){
            sizes = "180x180"
        }
    }
    //Manifest
    iconData.manifest?.let { manifest ->
        link(rel = "manifest", href = "${iconData.faviconRootPath}/$manifest")
    }
    //Mask Icon
    iconData.maskIcon?.let { icon ->
        iconData.maskColor?.let { color ->
            link(rel = "mask-icon", href = "${iconData.faviconRootPath}/$icon"){
                attributes["color"] = color
            }
        }
    }
    //MS Application
    iconData.msApplicationTitleColor?.let { color ->
        meta(name = "msapplication-TileColor", content = color)
    }
    //Theme Color
    iconData.themeColor?.let { color ->
        meta(name = "theme-color", content = color)
    }
}
