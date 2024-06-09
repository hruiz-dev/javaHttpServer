import java.net.HttpCookie;
import java.util.List;
import java.util.Map;

public class ClientData {
    // URL de la solicitud
    private String url;

    @HeaderMapping("Cookie")
    // Lista de cookies enviadas con la solicitud
    private List<HttpCookie> cookies;

    @HeaderMapping("Sec-fetch-dest")
    // Destino de la solicitud (por ejemplo, "document")
    private String fetchDest;

    @HeaderMapping("Accept")
    // Tipos de contenido que el cliente acepta
    private List<String> accept;

    @HeaderMapping("Sec-ch-ua")
    // Información de navegador (por ejemplo, versión de navegador y plataforma)
    private List<Map<String, Integer>> navInfo;

    @HeaderMapping("Sec-fetch-user")
    // Indica si la solicitud fue causada por una interacción del usuario (1 para sí, 0 para no)
    private String interactionCause;

    @HeaderMapping("Connection")
    // Tipo de conexión (por ejemplo, "keep-alive")
    private String connection;

    @HeaderMapping("Host")
    // Host al que se desea acceder
    private String host;

    @HeaderMapping("Sec-fetch-site")
    // Relación del sitio de origen de la solicitud (por ejemplo, "none")
    private String fetchSite;

    @HeaderMapping("Sec-ch-ua-platform")
    // Plataforma del cliente (por ejemplo, "Windows")
    private String uaPlatform;

    @HeaderMapping("Sec-fetch-mode")
    // Modo de la solicitud (por ejemplo, "navigate")
    private String fetchMode;

    @HeaderMapping("User-agent")
    // Información del agente de usuario
    private String userAgent;

    @HeaderMapping("Accept-language")
    // Idiomas aceptados por el cliente
    private String acceptLanguage;

    @HeaderMapping("Upgrade-insecure-requests")
    // Preferencia del cliente por conexiones seguras
    private int upgradeInsecureRequests;

    @HeaderMapping("Sec-gpc")
    // Preferencia del cliente de no ser rastreado (1 para sí, 0 para no)
    private int globalPrivacyControl;

    @HeaderMapping("Cache-control")
    // Control de caché (por ejemplo, "max-age=0")
    private String cacheControl;

    @HeaderMapping("Referrer")
    // URL de referencia desde donde se hizo la solicitud
    private String referer;

    @HeaderMapping("Accept-encoding")
    // Métodos de compresión aceptados por el cliente
    private List<String> acceptEncoding;

    // Constructor vacío
    public ClientData() {}

    // Constructor con parámetros para inicializar todas las variables
    public ClientData(String url, List<HttpCookie> cookies, String fetchDest, List<String> accept,
                      List<Map<String, Integer>> navInfo, String interactionCause, String connection, String host,
                      String fetchSite, String uaPlatform, String fetchMode, String userAgent, String acceptLanguage,
                      int upgradeInsecureRequests, int globalPrivacyControl, String cacheControl, String referer,
                      List<String> acceptEncoding) {
        this.url = url;
        this.cookies = cookies;
        this.fetchDest = fetchDest;
        this.accept = accept;
        this.navInfo = navInfo;
        this.interactionCause = interactionCause;
        this.connection = connection;
        this.host = host;
        this.fetchSite = fetchSite;
        this.uaPlatform = uaPlatform;
        this.fetchMode = fetchMode;
        this.userAgent = userAgent;
        this.acceptLanguage = acceptLanguage;
        this.upgradeInsecureRequests = upgradeInsecureRequests;
        this.globalPrivacyControl = globalPrivacyControl;
        this.cacheControl = cacheControl;
        this.referer = referer;
        this.acceptEncoding = acceptEncoding;
    }

    // Getters y setters para todas las variables

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<HttpCookie> getCookies() {
        return cookies;
    }

    public void setCookies(List<HttpCookie> cookies) {
        this.cookies = cookies;
    }

    public String getFetchDest() {
        return fetchDest;
    }

    public void setFetchDest(String fetchDest) {
        this.fetchDest = fetchDest;
    }

    public List<String> getAccept() {
        return accept;
    }

    public void setAccept(List<String> accept) {
        this.accept = accept;
    }

    public List<Map<String, Integer>> getNavInfo() {
        return navInfo;
    }

    public void setNavInfo(List<Map<String, Integer>> navInfo) {
        this.navInfo = navInfo;
    }

    public String getInteractionCause() {
        return interactionCause;
    }

    public void setInteractionCause(String interactionCause) {
        this.interactionCause = interactionCause;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getFetchSite() {
        return fetchSite;
    }

    public void setFetchSite(String fetchSite) {
        this.fetchSite = fetchSite;
    }

    public String getUaPlatform() {
        return uaPlatform;
    }

    public void setUaPlatform(String uaPlatform) {
        this.uaPlatform = uaPlatform;
    }

    public String getFetchMode() {
        return fetchMode;
    }

    public void setFetchMode(String fetchMode) {
        this.fetchMode = fetchMode;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    public int getUpgradeInsecureRequests() {
        return upgradeInsecureRequests;
    }

    public void setUpgradeInsecureRequests(int upgradeInsecureRequests) {
        this.upgradeInsecureRequests = upgradeInsecureRequests;
    }

    public int getGlobalPrivacyControl() {
        return globalPrivacyControl;
    }

    public void setGlobalPrivacyControl(int globalPrivacyControl) {
        this.globalPrivacyControl = globalPrivacyControl;
    }

    public String getCacheControl() {
        return cacheControl;
    }

    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public List<String> getAcceptEncoding() {
        return acceptEncoding;
    }

    public void setAcceptEncoding(List<String> acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }
}
