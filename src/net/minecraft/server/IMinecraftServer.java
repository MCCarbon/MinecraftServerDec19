package net.minecraft.server;

public interface IMinecraftServer {
   int a(String var1, int var2);

   String a(String var1, String var2);

   void a(String var1, Object var2);

   void a();

   String b();

   String E();

   int F();

   String G();

   String getVersion();

   int I();

   int J();

   String[] getPlayers();

   String U();

   String getPlugins();

   String a_(String var1);

   boolean isDebugging();

   void info(String var1);

   void warning(String var1);

   void g(String var1);

   void h(String var1);
}
