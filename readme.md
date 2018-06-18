HTTP/1.1 302 Found
Location: https://accounts.google.com/o/oauth2/v2/auth?
redirect_uri=https%3A%2F%2Fdevelopers.google.com%2Foauthplayground&
prompt=consent&
response_type=code&
client_id=407408718192.apps.googleusercontent.com&
scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fxapi.zoo+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fxapi.zoo+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fcalendar.readonly&access_type=offline
GET /oauthplayground/?code=4/AACLgapSw6fcIE4jZzozH7qldoBV7OrNTKd08WCStN1Xya_tcUPuwnEL8oRPCNpofG3ZyCM7sv-hWAZc9lNrXJA HTTP/1.1
Host: developers.google.com


Request / Response
POST /oauth2/v4/token HTTP/1.1
Host: www.googleapis.com
Content-length: 277
content-type: application/x-www-form-urlencoded
user-agent: google-oauth-playground
code=4%2FAACLgapSw6fcIE4jZzozH7qldoBV7OrNTKd08WCStN1Xya_tcUPuwnEL8oRPCNpofG3ZyCM7sv-hWAZc9lNrXJA&redirect_uri=https%3A%2F%2Fdevelopers.google.com%2Foauthplayground&client_id=407408718192.apps.googleusercontent.com&client_secret=************&scope=&grant_type=authorization_code
HTTP/1.1 200 OK
Content-length: 287
X-xss-protection: 1; mode=block
X-content-type-options: nosniff
Transfer-encoding: chunked
Expires: Mon, 01 Jan 1990 00:00:00 GMT
Vary: Origin, X-Origin
Server: GSE
-content-encoding: gzip
Pragma: no-cache
Cache-control: no-cache, no-store, max-age=0, must-revalidate
Date: Mon, 18 Jun 2018 06:58:48 GMT
X-frame-options: SAMEORIGIN
Alt-svc: quic=":443"; ma=2592000; v="43,42,41,39,35"
Content-type: application/json; charset=UTF-8
{
  "access_token": "ya29.GlveBRyizPbyGRPPQTsWWsyi4gAnV7KqUvMB6wobRaMXeW2vtF1L6gOPcPnjk9djnXeHKLX9-ftBn1Qh1O-baxZEgxYcc7UlJpW_hEbJxJvmItMngnEamCr1sJ8d", 
  "token_type": "Bearer", 
  "expires_in": 3600, 
  "refresh_token": "1/xa8aylIGwskNLUT-1T2-mfy7j8FOyNwXi5xqHOSa38LptdtcWtoDKh0NmAdJfPOm"
}


Request / Response
GET /o/oauth2/v2/auth?redirect_uri=https://developers.google.com/oauthplayground&prompt=consent&response_type=code&client_id=407408718192.apps.googleusercontent.com&scope=https://www.googleapis.com/auth/xapi.zoo&access_type=offline HTTP/1.1
Host: accounts.google.com
Content-length: 0
Authorization: Bearer ya29.GlveBRyizPbyGRPPQTsWWsyi4gAnV7KqUvMB6wobRaMXeW2vtF1L6gOPcPnjk9djnXeHKLX9-ftBn1Qh1O-baxZEgxYcc7UlJpW_hEbJxJvmItMngnEamCr1sJ8d
HTTP/1.1 302 Found
Content-length: 0
X-xss-protection: 1; mode=block
Content-language: en-US
Content-security-policy: script-src 'report-sample' 'nonce-zesTyPdbb3PN0eI7a6B+Oa9jHIU' 'unsafe-inline' 'strict-dynamic' https: http: 'unsafe-eval';object-src 'none';base-uri 'none';report-uri /o/cspreport
Set-cookie: NID=132=VpskIsf2GwoM_h_L2NIL3QgQS1JBQr3JgaBMIT1b44ZbLBPfzAD2Nx2BWve-QWzkQjpTiF4e6J3dFBJgIL3p6f1mdOjZKpab2Ly40c8tWpTIGZVYbNTyVmffWbaHyHX8;Domain=.google.com;Path=/;Expires=Tue, 18-Dec-2018 06:59:07 GMT;HttpOnly
Server: ESF
Location: https://accounts.google.com/ServiceLogin?passive=1209600&continue=https://accounts.google.com/o/oauth2/v2/auth?redirect_uri%3Dhttps://developers.google.com/oauthplayground%26prompt%3Dconsent%26response_type%3Dcode%26client_id%3D407408718192.apps.googleusercontent.com%26scope%3Dhttps://www.googleapis.com/auth/xapi.zoo%26access_type%3Doffline%26from_login%3D1%26as%3DvFRqNs5goFpCNrC_M0avsA&followup=https://accounts.google.com/o/oauth2/v2/auth?redirect_uri%3Dhttps://developers.google.com/oauthplayground%26prompt%3Dconsent%26response_type%3Dcode%26client_id%3D407408718192.apps.googleusercontent.com%26scope%3Dhttps://www.googleapis.com/auth/xapi.zoo%26access_type%3Doffline%26from_login%3D1%26as%3DvFRqNs5goFpCNrC_M0avsA&oauth=1&sarp=1&scc=1
Date: Mon, 18 Jun 2018 06:59:07 GMT
P3p: CP="This is not a P3P policy! See g.co/p3phelp for more info."
Alt-svc: quic=":443"; ma=2592000; v="43,42,41,39,35"
Content-type: application/binary
X-frame-options: SAMEORIGIN