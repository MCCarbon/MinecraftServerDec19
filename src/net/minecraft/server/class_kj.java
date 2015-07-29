package net.minecraft.server;

public final class class_kj extends RuntimeException {
   public static final class_kj a = new class_kj();

   private class_kj() {
      this.setStackTrace(new StackTraceElement[0]);
   }

   public synchronized Throwable fillInStackTrace() {
      this.setStackTrace(new StackTraceElement[0]);
      return this;
   }
}
