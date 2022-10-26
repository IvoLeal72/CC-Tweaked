/*
 * This file is part of ComputerCraft - http://www.computercraft.info
 * Copyright Daniel Ratcliffe, 2011-2022. Do not distribute without permission.
 * Send enquiries to dratcliffe@gmail.com
 */
package dan200.computercraft.shared.computer.core;

import dan200.computercraft.shared.computer.menu.ServerInputHandler;

import javax.annotation.Nullable;

/**
 * Handles user-provided input, forwarding it to a computer. This is used
 *
 * @see ServerInputHandler
 * @see ServerComputer
 */
public interface InputHandler
{
    void queueEvent( String event, @Nullable Object[] arguments );

    default void queueEvent( String event )
    {
        queueEvent( event, null );
    }

    default void keyDown( int key, boolean repeat )
    {
        queueEvent( "key", new Object[] { key, repeat } );
    }

    default void keyUp( int key )
    {
        queueEvent( "key_up", new Object[] { key } );
    }

    default void mouseClick( int button, int x, int y )
    {
        queueEvent( "mouse_click", new Object[] { button, x, y } );
    }

    default void mouseUp( int button, int x, int y )
    {
        queueEvent( "mouse_up", new Object[] { button, x, y } );
    }

    default void mouseDrag( int button, int x, int y )
    {
        queueEvent( "mouse_drag", new Object[] { button, x, y } );
    }

    default void mouseScroll( int direction, int x, int y )
    {
        queueEvent( "mouse_scroll", new Object[] { direction, x, y } );
    }

    void shutdown();

    void turnOn();

    void reboot();
}
