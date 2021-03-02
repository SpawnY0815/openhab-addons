# Mercedes Binding

With this binding it should be possible to connect to the Mercedes-Benz API to read data from your vehicle.

## requirements:
* Mercedes-Benz ME User Account
* Mercedes-Benz Devoloper App
* VIN

### Mercedes-Benz App
1. Open web browser https://developer.mercedes-benz.com/
2. Use you Mercedes Benz ME login data to login to developers platform
3. Select "CONSOLE" in the navigation
4. Select "+ ADD NEW APP"
5. Give the APP a name, this needs to be unique
    * Example: "yourname-yourvehiclename-openhab"
6. Set your "Redirect URL"
    * Example: "http://openhabian:8080/mb-connect.html" or "http://192.168.10.50:8080/mb-connect.html" (with your openHAB IP or dns name)
7. Give business purpose
    * Example: "Connect my car to openHAB smarthome"
8. Select "APIs" in the navigation
9. SUBCRIBE to APIs matching your vehicle (use BYOCAR and GET FOR FREE)
    * Fuel Status BYOCAR
    * Pay As You Drive Insurance BYOCAR
    * Vehicle Lock Status BYOCAR
    * Vehicle Status BYOCAR
    * Electric Vehicle Status BYOCAR (only electric or hybrid car)
10. Select "CONSOLE" in the navigation
11. Copy Client_ID, Client_Secret data.


### The Auth process:
https://developer.mercedes-benz.com/doc/general/oauth/documentation/oauth_authorization_code_flow.png

_Authorization Code Flow

Currently, some of our APIs support the OAuth Authorization Code Flow. The flow provides the ability for the resource owners (owners of the data to access / the Mercedes-Benz customers) to authorize applications to access their personal data. Your application can use this flow including all built-in features like customer login and consent handling in order to get the authorization by the resource owner.

These are the steps that the flow executes:

1. Redirect the end user’s browser to the authorization endpoint
    * At this point you need to put in the (in the mercedes dev app) selected Scopes in the auth request (example: "mb:vehicle:mbdata:fuelstatus"), so you need to do some binding settings before this point and select which scopes you have subcribed + your client_id

2. Authenticate the end user and ask for consent

3. Redirect the end user to your application’s callback URL with an authorization code

4. Request to exchange the authorization code with an access token

5. Use the access token to call the API on behalf of the end user
    * after this point we also have an refresh token. so i need to save the last token time and compare with now to see if i need to refresh the access_token with the refresh_token



## Supported Things

_Please describe the different supported things / devices within this section._
_Which different types are supported, which models were tested etc.?_
_Note that it is planned to generate some part of this based on the XML files within ```src/main/resources/OH-INF/thing``` of your binding._

There is just one typ of thing : vehicle



## Discovery

_Describe the available auto-discovery features here. Mention for what it works and what needs to be kept in mind when using it._

not possible

## Binding Configuration

not needed

## Thing Configuration

_Describe what is needed to manually configure a thing, either through the (Paper) UI or via a thing-file. This should be mainly about its mandatory and optional configuration parameters. A short example entry for a thing file can help!_

_Note that it is planned to generate some part of this based on the XML files within ```src/main/resources/OH-INF/thing``` of your binding._

The thing "vehicle" needs these settings:
* Client_id
* Client_secret
* subcribed scopes
    * Fuel Status
    * Pay As You Drive Insurance
    * Vehicle Lock Status
    * Vehicle Status
    * Electric Vehicle Status
* VIN (Vehicle Ident Number)
* Refresh rate

## Channels

_Here you should provide information about available channel types, what their meaning is and how they can be used._

_Note that it is planned to generate some part of this based on the XML files within ```src/main/resources/OH-INF/thing``` of your binding._

| channel  | type   | description                  |
|----------|--------|------------------------------|
| control  | Switch | This is the control channel  |
| rangeliquid | Number | Liquid fuel tank range |
| tanklevelpercent | Number | Liquid fuel tank level |
| decklidstatus | Contact | Deck lid latch status opened/closed state |
| doorstatusfrontleft | Contact | Status of the front left door |
| doorstatusfrontright | Contact | Status of the front right door |
| doorstatusrearleft | Contact | Status of the rear left door |
| doorstatusrearright | Contact | Status of the rear right door |
| interiorLightsFront | Switch | Front light inside |
| interiorLightsRear | Switch | Rear light inside |
| lightswitchposition | Number | Rotary light switch position |
| readingLampFrontLeft | Switch | Front left reading light inside |
| readingLampFrontRight | Switch | Front right reading light inside |
| rooftopstatus | Number | Status of the convertible top opened/closed |
| sunroofstatus | Number | Status of the sunroof |
| windowstatusfrontleft | Number | Status of the front left window |
| windowstatusfrontright | Number | Status of the front right window |
| windowstatusrearleft | Number | Status of the rear left window |
| windowstatusrearright | Number | Status of the rear right window |
| doorlockstatusdecklid | Switch | Lock status of the deck lid |
| doorlockstatusvehicle | Number | Vehicle lock status |
| doorlockstatusgas | Switch | Status of gas tank door lock |
| positionHeading | Number | Vehicle heading position |
| soc | Number | Displayed state of charge for the HV battery |
| rangeelectric | Number | Electric range |
| odo | Number | Odometer |

**!! each listed value also has a timestamp in form of datetime**


## Full Example

_Provide a full usage example based on textual configuration files (*.things, *.items, *.sitemap)._

mercedes.things

	Thing mercedes:vehicle:mycar 			"E-Class" 					[ client_id="", client_secret="", vin="", refresh=60 ]


mercedes.items

    // Fuel Status
    Number:Length           mbc_data_rangeliquid                  "Liquid fuel tank range [%s km]"                                        (gMBC)
    Number:Dimensionless    mbc_data_tanklevelpercent             "Liquid fuel tank level [%s %%]"                                        (gMBC)

    // Vehicle Status
    Contact                 mbc_data_decklidstatus                "Deck lid latch status opened/closed state [%s]"                        (gMBC)
    Contact                 mbc_data_doorstatusfrontleft          "Status of the front left door [%s]"                                    (gMBC)
    Contact                 mbc_data_doorstatusfrontright         "Status of the front right door [%s]"                                   (gMBC)
    Contact                 mbc_data_doorstatusrearleft           "Status of the rear left door [%s]"                                     (gMBC)
    Contact                 mbc_data_doorstatusrearright          "Status of the rear right door [%s]"                                    (gMBC)
    Switch                  mbc_data_interiorLightsFront          "Front light inside [%s]"                                               (gMBC)
    Switch                  mbc_data_interiorLightsRear           "Rear light inside [%s]"                                                (gMBC)
    Number                  mbc_data_lightswitchposition          "Rotary light switch position [MAP(mbc_lightswitch.map):%s]"            (gMBC)
    Switch                  mbc_data_readingLampFrontLeft         "Front left reading light inside [%s]"                                  (gMBC)
    Switch                  mbc_data_readingLampFrontRight        "Front right reading light inside [%s]"                                 (gMBC)
    Number                  mbc_data_rooftopstatus                "Status of the convertible top opened/closed [MAP(mbc_lock.map):%s]"    (gMBC)
    Number                  mbc_data_sunroofstatus                "Status of the sunroof [MAP(mbc_sunroof.map):%s]"                       (gMBC)
    Number                  mbc_data_windowstatusfrontleft        "Status of the front left window [MAP(mbc_windows.map):%s]"             (gMBC)
    Number                  mbc_data_windowstatusfrontright       "Status of the front right window [MAP(mbc_windows.map):%s]"            (gMBC)
    Number                  mbc_data_windowstatusrearleft         "Status of the rear left window [MAP(mbc_windows.map):%s]"              (gMBC)
    Number                  mbc_data_windowstatusrearright        "Status of the rear right window [MAP(mbc_windows.map):%s]"             (gMBC)

    // Vehicle Lock Status
    Switch                  mbc_data_doorlockstatusdecklid        "Lock status of the deck lid [MAP(mbc_lock.map):%s]"                    (gMBC)
    Number                  mbc_data_doorlockstatusvehicle        "Vehicle lock status [MAP(mbc_lock.map):%s]"                            (gMBC)
    Switch                  mbc_data_doorlockstatusgas            "Status of gas tank door lock [MAP(mbc_lock.map):%s]"                   (gMBC)
    Number:Angle            mbc_data_positionHeading              "Vehicle heading position [%.1f °]"                                     (gMBC)

    // Electric Vehicle Status
    Number:Dimensionless    mbc_data_soc                          "charge for the HV battery [%s %%]"                                     (gMBC)
    Number:Length           mbc_data_rangeelectric                "Electric range [%s km]"                                                (gMBC)

    // Pay As You Drive Insurance
    Number:Length           mbc_data_odo                          "Odometer [%s km]"                                                      (gMBC)

    // Timestamps
    DateTime                mbc_data_rangeliquid_ts               "Liquid fuel tank range last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"       (gMBC)
    DateTime                mbc_data_tanklevelpercen_ts           "Liquid fuel tank level last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"       (gMBC)
    DateTime                mbc_data_decklidstatus_ts             "decklidstatus last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"                (gMBC)
    DateTime                mbc_data_doorstatusfrontleft_ts       "doorstatusfrontleft last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"          (gMBC)
    DateTime                mbc_data_doorstatusfrontright_ts      "doorstatusfrontright last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"         (gMBC)
    DateTime                mbc_data_doorstatusrearleft_ts        "doorstatusrearleft last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"           (gMBC)
    DateTime                mbc_data_doorstatusrearright_ts       "doorstatusrearright last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"          (gMBC)
    DateTime                mbc_data_interiorLightsFront_ts       "interiorLightsFront last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"          (gMBC)
    DateTime                mbc_data_interiorLightsRear_ts        "interiorLightsRear last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"           (gMBC)
    DateTime                mbc_data_lightswitchposition_ts       "lightswitchposition last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"          (gMBC)
    DateTime                mbc_data_readingLampFrontLeft_ts      "readingLampFrontLeft last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"         (gMBC)
    DateTime                mbc_data_readingLampFrontRight_ts     "readingLampFrontRight last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"        (gMBC)
    DateTime                mbc_data_rooftopstatus_ts             "rooftopstatus last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"                (gMBC)
    DateTime                mbc_data_sunroofstatus_ts             "sunroofstatus last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"                (gMBC)
    DateTime                mbc_data_windowstatusfrontleft_ts     "windowstatusfrontleft last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"        (gMBC)
    DateTime                mbc_data_windowstatusfrontright_ts    "windowstatusfrontright last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"       (gMBC)
    DateTime                mbc_data_windowstatusrearleft_ts      "windowstatusrearleft last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"         (gMBC)
    DateTime                mbc_data_windowstatusrearright_ts     "windowstatusrearright last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"        (gMBC)
    DateTime                mbc_data_doorlockstatusdecklid_ts     "doorlockstatusdecklid last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"        (gMBC)
    DateTime                mbc_data_doorlockstatusvehicle_ts     "doorlockstatusvehicle last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"        (gMBC)
    DateTime                mbc_data_doorlockstatusgas_ts         "doorlockstatusgas last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"            (gMBC)
    DateTime                mbc_data_positionHeading_ts           "positionHeading last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"              (gMBC)
    DateTime                mbc_data_soc_ts                       "soc last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"                          (gMBC)
    DateTime                mbc_data_rangeelectric_ts             "rangeelectric last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"                (gMBC)
    DateTime                mbc_data_odo_ts                       "odo last ts [%1$tY-%1$tm-%1$td  %1$tH:%1$tM]"                          (gMBC)


mercedes.sitemap

    sitemap mb_connect label="MB-Connect"
    {
        Frame label="Data - Vehicle Status" {
            Default item=mbc_data_decklidstatus         
            Default item=mbc_data_doorstatusfrontleft   
            Default item=mbc_data_doorstatusfrontright  
            Default item=mbc_data_doorstatusrearleft    
            Default item=mbc_data_doorstatusrearright   
            Default item=mbc_data_interiorLightsFront   
            Default item=mbc_data_interiorLightsRear    
            Default item=mbc_data_lightswitchposition   
            Default item=mbc_data_readingLampFrontLeft  
            Default item=mbc_data_readingLampFrontRight 
            Default item=mbc_data_rooftopstatus         
            Default item=mbc_data_sunroofstatus         
            Default item=mbc_data_windowstatusfrontleft 
            Default item=mbc_data_windowstatusfrontright
            Default item=mbc_data_windowstatusrearleft  
            Default item=mbc_data_windowstatusrearright 
        }			
        Frame label="Data - Fuel Status" {
            Default item=mbc_data_rangeliquid       
            Default item=mbc_data_tanklevelpercent  
        }	
        Frame label="Data - Vehicle Lock Status" {
            Default item=mbc_data_doorlockstatusdecklid
            Default item=mbc_data_doorlockstatusvehicle
            Default item=mbc_data_doorlockstatusgas    
            Default item=mbc_data_positionHeading      
        }	
        Frame label="Data - Electric Vehicle Status" {
            Default item=mbc_data_soc          
            Default item=mbc_data_rangeelectric   
        }	
        Frame label="Data - Pay As You Drive Insurance" {
            Default item=mbc_data_odo     
        }	
        Frame label="Timestamps" {
            Default item=mbc_data_rangeliquid_ts           
            Default item=mbc_data_tanklevelpercen_ts       
            Default item=mbc_data_decklidstatus_ts         
            Default item=mbc_data_doorstatusfrontleft_ts   
            Default item=mbc_data_doorstatusfrontright_ts  
            Default item=mbc_data_doorstatusrearleft_ts    
            Default item=mbc_data_doorstatusrearright_ts   
            Default item=mbc_data_interiorLightsFront_ts   
            Default item=mbc_data_interiorLightsRear_ts    
            Default item=mbc_data_lightswitchposition_ts   
            Default item=mbc_data_readingLampFrontLeft_ts  
            Default item=mbc_data_readingLampFrontRight_ts 
            Default item=mbc_data_rooftopstatus_ts         
            Default item=mbc_data_sunroofstatus_ts         
            Default item=mbc_data_windowstatusfrontleft_ts 
            Default item=mbc_data_windowstatusfrontright_ts
            Default item=mbc_data_windowstatusrearleft_ts  
            Default item=mbc_data_windowstatusrearright_ts 
            Default item=mbc_data_doorlockstatusdecklid_ts 
            Default item=mbc_data_doorlockstatusvehicle_ts 
            Default item=mbc_data_doorlockstatusgas_ts     
            Default item=mbc_data_positionHeading_ts       
            Default item=mbc_data_soc_ts                   
            Default item=mbc_data_rangeelectric_ts         
            Default item=mbc_data_odo_ts                   
        }
    }

## Any custom content here!

_Feel free to add additional sections for whatever you think should also be mentioned about your binding!_
