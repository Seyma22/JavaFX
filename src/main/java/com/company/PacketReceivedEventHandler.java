package com.company;

public interface PacketReceivedEventHandler
{

    void received(String ipAddress, String original, String reversed);
}
