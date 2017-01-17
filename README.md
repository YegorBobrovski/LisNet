# LisNet

LisNet is a hardware-software complex for sound monitoring network creation  
Consists of two types of devices: transmitters and receivers

## Transmitter
Small portable device based on ESP8266 module with connected microphone which:
* can create access point (AP) to connect receivers and other transmitters
* can be configured to connect to other existing APs

## Receiver
Android app that allows to:
* search for transmitters in wireless network
* notify if transmitter detects any noise and play it with speakers
* configure connected transmitter
